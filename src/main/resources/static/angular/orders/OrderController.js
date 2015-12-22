(function() {
    'use strict';

    angular.module('storeApp')
        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider
                .when("/orders", {
                    templateUrl: "/orders/orderlisting.html",
                    controller: "OrdersController",
                    controllerAs: "vm"
                })
                .when("/orderDetails/:id", {
                    templateUrl: "/orders/orderDetails.html",
                    controller: "OrderDetailsController",
                    controllerAs: "vm"
                })
        }])
        .controller('OrdersController', OrdersController)
        .controller('OrderDetailsController', OrderDetailsController);

    OrdersController.$inject = ['$http']
    function OrdersController($http){
        var vm = this;

        activate();

        function activate(){

            getOrders();

            //$http.get('user', {}).success(function(data){
            //    console.log(data);
            //    vm.customer = data;
            //    vm.customerId = data.principal.id;
            //}).error(function() {
            //    return {};
            //});
        }

        function getOrders(){
            $http.get("/getallorders").success(function(data){
                vm.orders = data;

                vm.orders.forEach(function(order){
                    $http.get("/getcustomerbyid?customerId=" + order.customerId).success(function(cust){
                        order.customerName = cust.customerFirstName + " " + cust.customerLastName;
                    })
                })
            })
        }
    }

    OrderDetailsController.$inject = ['$http', '$routeParams']
    function OrderDetailsController($http, $routeParams){
        var vm = this;
        vm.orderId = $routeParams.id;

        activate();

        function activate(){
            getOrderDetails();
        }

        function getOrderDetails(){
            $http.get("/getcustomerorderitems?orderId=" + vm.orderId).success(function(data){
                vm.orderDetails = data;

                vm.orderDetails.forEach(function(item){
                    $http.get("/getProd?id=" + item.productId).success(function(prod){
                        item.productName = prod.productName;
                    })
                })
            })
        }

    }


})();