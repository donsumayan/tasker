// User Services
(function() {
    'use strict';
    angular
        .module('todo.components.services')
        .factory('userservice', userservice);

    // user services:
    //     /login  --// login
    //     /user/{x} --// get specific user
    //     /user/{x} --// delete user
    //     /user/{x} --// update user
    function userservice($http, $cookies, constants) {
        var url = constants.SERVICE_URL;

        return {
            login: login,
            createUser: createUser,
            getUser: getUser,
            getUsers: getUsers,
            delUser: deleteUser,
            updateUser: updateUser
        };

        function login(user) {
            // console.log(user);
            return $http.post(url + 'login', user)
                .then(onComplete)
                .catch(onFail);

            function onComplete(response) {
                // console.log(response);
                return response.data;
            }

            function onFail(error) {
                console.log(error);
                // return tempUser;
            }
        }

        function createUser(user) {
            user.role = {
                "id": 2,
                "name": "User"
            };

            return $http.post(url + 'users', user)
                .then(onComplete)
                .catch(onFail);

            function onComplete(response) {
                return response.data;
            }

            function onFail(error) {
                console.log(error);
            }

        }

        function getUser(id) {

            $http.defaults.headers.common.Authorization = 'Basic dmluY2VudEBnbWFpbC5jb206MTIzNDU=';
            return $http.get(url + 'users/' + id)
                .then(onComplete)
                .catch(onFail);

            function onComplete(response) {
                return response.data;
            }

            function onFail(error) {
                console.log(error);
                return tempUser;
            }

        }

        function getUsers() {

            $http.defaults.headers.common.Authorization = 'Basic dmluY2VudEBnbWFpbC5jb206MTIzNDU=';
            return $http.get(url + 'users/' + id)
                .then(onComplete)
                .catch(onFail);

            function onComplete(response) {
                return response.data;
            }

            function onFail(error) {
                console.log(error);
                return tempUser;
            }

        }

        function updateUser(user) {
            user.password = "";
            user.role = {
                "id": 2,
                "name": "User"
            };
            $http.defaults.headers.common.Authorization = $cookies.get('Auth');
            return $http.put(url + 'users/' + user.id, user)
                .then(onComplete)
                .catch(onFail);

            function onComplete(response) {
                return user;
            }

            function onFail(error) {
                console.log(error);
            }
        }

        function deleteUser(id) {
            $http.defaults.headers.common.Authorization = $cookies.get('Auth');
            return $http.delete(url + 'user/' + id)
                .then(onComplete)
                .catch(onFail);

            function onComplete(response) {
                return response.data;
            }

            function onFail(error) {
                console.log(error);
            }
        }
    }

})();
