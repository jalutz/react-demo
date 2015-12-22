(function(){
    'use strict';

    angular.module('storeApp')
        .config(['$routeProvider', function($routeProvider){
            $routeProvider
            .when("/login", {
                templateUrl: "/customers/login.html",
                controller: "CustomerController",
                controllerAs: "vm"
            }).
            when("/newUser", {
                templateUrl: "/customers/newUser.html",
                controller: "CustomerCreateController",
                controllerAs: "vm"
            }).
            when("/newUserSuccess", {
                templateUrl: "/customers/newUserSuccess.html"
            })
        }])
        .controller('CustomerController', CustomerController)
        .controller('CustomerCreateController', CustomerCreateController);


    CustomerController.$inject = ['$http', '$rootScope', '$location', '$timeout'];
    function CustomerController($http, $rootScope, $location, $timeout){
        var vm = this;
        vm.badInfo = false;

        vm.login = function()
        {
            var credentials = {
                username: vm.username,
                password: vm.password
            };

            $timeout(authenticate(credentials, redirectToUrl()), 300);

            vm.badInfo = $rootScope.authenticated;
        };

        var authenticate = function(credentials, callback) {

            var headers = credentials ? {authorization : "Basic "
            + btoa(credentials.username + ":" + credentials.password)
            } : {};

            $http.get('user', {headers : headers}).success(function(data) {

                if (data.name) {
                    $rootScope.authenticated = true;
                } else {
                    $rootScope.authenticated = false;
                }
                callback && callback();
            }).error(function() {
                console.log("error");

                $rootScope.authenticated = false;
                callback && callback();
            });
        };

        authenticate();

        var redirectToUrl = function(){
            window.location.href = "/#/";
        };
    }

    CustomerCreateController.$inject = ['$http'];
    function CustomerCreateController($http){
        var vm = this;

        vm.createNewUser = function()
        {
            vm.errorCount = 0;
            vm.isPasswordRptError = false;
            vm.isUsernameError = false;
            vm.isEmailError = false;
            vm.isPasswordError = false;

            $http.get('/findcustomerbyusername?customerLogin=' + vm.userName).success(function(data){
                if(Object.keys(data).length > 0){
                    vm.isUsernameError = true;
                    vm.errorCount++;
                }

                $http.get('/findcustomerbyemail?customerEmail='+vm.email).success(function(data) {
                    if (Object.keys(data).length > 0)
                    {
                        vm.isEmailError = true;
                        vm.errorCount++;
                    }
                    validate();
                })
            });

            function validate()
            {
                if(vm.password != vm.passwordRpt){
                    vm.errorCount++;
                    vm.isPasswordRptError = true;
                    vm.passwordRptError = "Password and confirm password must match.";
                }
                else if(vm.password.indexOf('.') != -1 || vm.password.indexOf(' ') != -1)
                {
                    vm.errorCount++;
                    vm.isPasswordError = true;
                    vm.passwordError = "Your password cannot contain a period or a space.";
                }
                else
                {
                    if(vm.errorCount == 0)
                    {
                        var customer = {
                            customerFirstName: vm.firstName,
                            customerLastName: vm.lastName,
                            customerLogin: vm.userName,
                            customerPassword: vm.password,
                            customerEmail: vm.email
                        };

                        var jsonCust = JSON.stringify(customer);

                        $http.post("/addcustomer", jsonCust).then(function(){
                            window.location.href = "/#/newUserSuccess";
                        });
                    }
                }
            }
        }
    }
})();