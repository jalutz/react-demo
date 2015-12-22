(function(){
    'use strict';

    angular.module('storeApp')
        .config(['$routeProvider', function($routeProvider){
            $routeProvider
                .when("/products", {
                    templateUrl: "/products/productlisting.html",
                    controller: "ProductController",
                    controllerAs: "vm"
                })
        }])
        .controller('ProductController', ProductController);

    ProductController.$inject = ['$http', '$scope', '$timeout'];
    function ProductController($http, $scope, $timeout){
        var vm = this;

        vm.addToCart = function(p)
        {
            var prod = {
                productId: p.productId,
                quantity: p.itemQty,
                productPrice: p.itemQty * p.unitPrice
            };

            var item = JSON.stringify(prod);

            $http.post("/addcartitem?customerId="+vm.customerId, item).then(function(){
                //getCartItems();
               location.reload();
            });
        };

        activate();

        function activate()
        {
            $timeout(getUserId, 300);
        }

        function getUserId() {
            $http.get('user', {}).success(function(data) {
                if (data.name) {
                    vm.customerId = data.principal.id;
                    vm.userName = data.name;
                    getProducts();
                } else {
                    window.location.href = "/#/";
                }
            }).error(function() {
                console.log("user error");
            });
        }

        function getProducts()
        {
            $http.get("/getproducts").success(function(data){
                var productList = data;

                vm.products = productList;

                getCartItems();
            });
        }

        function getCartItems(){

            $http.get("/getcart?customerId=" + vm.customerId).success(function(data){
                if (Object.keys(data).length > 0)
                {
                    $http.get("/getcartitems?customerId=" + vm.customerId).then(function(data){
                        vm.cartItemCount = data.data.length;
                    })
                }
                else {
                    vm.cartItemCount = 0;
                }
            }).error(function(){
                vm.cartItemCount = 0;
            });


        }
    }
})();
