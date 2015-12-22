(function(){
    'use strict';

    angular.module('storeApp').factory('UserService', userService);

    userService.$inject = ['$http'];
    function userService($http)
    {
        console.log("this is from userservice");

        return{
            isUserLoggedOn:isUserLoggedOn,
            getUser: getUser
        };

        function getUser(){
            $http.get('user', {}).success(function(data){
                console.log(data);
                return data;
            }).error(function() {
                return {};
            });
        }

        function isUserLoggedOn(){
            $http.get('user', {}).success(function(data) {
                console.log(data.name);
                return !! data.name;
            }).error(function() {
                console.log(false);
                return false;
            });
        }
    }
})();

