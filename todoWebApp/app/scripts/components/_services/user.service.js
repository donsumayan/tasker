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
                "id":1,
                "first_name": "don",
                "last_name": "sumayan",
                "email": "don.sumayan@gmail.com",
                "role_id": "1"
            };

            return user;

        }
    }

})();
