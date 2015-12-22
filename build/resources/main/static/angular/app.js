(function(){
    'use strict';

    angular.module('storeApp', ['ngRoute', 'ngResource']);

    angular.module('storeApp').config(['$routeProvider', function($routeProvider){
        $routeProvider.
        when("/home", {
            templateUrl: "/home.html",
            controller: "HomeController",
            controllerAs: "vm"
        }).otherwise({
            redirectTo: "/home"
        });
    }])
        .controller('HomeController', HomeController)
        .controller('LogoutController', LogoutController);


    LogoutController.$inject = ['$http', '$rootScope', '$location'];
    function LogoutController($http, $rootScope, $location)
    {
        var vm = this;
        vm.logout = function()
        {
            $http.post('logout', {}).success(function() {
                $rootScope.authenticated = false;
                $location.path("/#/");
                location.reload();
            }).error(function() {
                $rootScope.authenticated = false;
            });
        }
    }

    HomeController.$inject = ['$http', '$rootScope', '$timeout'];
    function HomeController($http, $rootScope, $timeout){
        var vm = this;

        $timeout(activate, 300);

        function activate(){
            $http.get('user', {}).success(function(data){
                console.log(data);

                vm.userLoggedOn = Object.keys(data).length > 0;
                console.log(vm.userLoggedOn);
            }).error(function() {
                vm.userLoggedOn = false;
                return {};
            });
        }
    }
})();
