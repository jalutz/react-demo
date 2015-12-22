(function(){
    'use strict';

    angular.module('storeApp')
        .config(['$routeProvider', function($routeProvider){
            $routeProvider
                .when("/cartdetails", {
                    templateUrl: "/cart/cartDetails.html",
                    controller: "CartDetailsController",
                    controllerAs: "vm"
                })
                .when("/cartsuccess/:id", {
                    templateUrl: "/cart/cartSubmitSuccess.html",
                    controller: "cartSubmitController",
                    controllerAs: "vm"
                })
        }])
        .controller('CartDetailsController', CartDetailsController)
        .controller('CartSubmitController', CartSubmitController);

    CartDetailsController.$inject = ['$http', 'UserService'];
    function CartDetailsController($http, userService){
        var vm = this;
        vm.totalPrice = 0;
        activate();

        vm.submitOrder = function(customerId){
            $http.post('/submitorder?customerId=' + vm.customerId).success(function(data){
                window.location.href="/#/cartsuccess/" + data;
            })
        };

        vm.cancelOrder = function(){
            alert("order not submitted.");
        };

        vm.removeCartItem = function(id){
            $http.post('/removecartitem?cartDetailId=' + id).then(function(data){
                location.reload();
            })
        };

        function activate()
        {
            $http.get('user', {}).success(function(data){
                vm.customerId = data.principal.id;
                getCartItems();
            }).error(function() {
                return {};
            });
        }

        function getCartItems()
        {
            $http.get("/getcartitems?customerId=" + vm.customerId, {}).then(function(data){
                var items = data.data;
                items.forEach(function(item){
                    $http.get('/getProd?id=' + item.productId).success(function(data){
                        item.productName = data.productName;
                    });

                    vm.totalPrice += item.productPrice;
                });

                vm.cartDetails = items;
            })
        }
    }

    CartSubmitController.$inject = ['$routeParams']
    function CartSubmitController($routeParams){
        var vm = this;
        vm.orderId = $routeParams.id;
    }
})();