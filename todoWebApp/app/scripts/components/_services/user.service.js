// User Services
(function() {
    'use strict';
    angular
        .module('todo.components.services')
        .factory('userservice', userservice);


    function userservice() {
        return {
            getUser: user
        };

        function user() {
            var user = {
                "id": 1,
                "firstName": "Don",
                "lastName": "Sumayan",
                "email": "don.sumayan@gmail.com",
                "password": "",
                "role": {
                    "id": 1,
                    "name": "user"
                }
            };

            return user;

        }
    }

})();
