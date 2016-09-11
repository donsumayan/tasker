// To-do Services
(function() {
    'use strict';
    angular
        .module('todo.components.services')
        .factory('todoservice', todoservice);


    // /user/{x}/todos --// get list of todos per user
    // /user/{x}/todos --// create todos per user
    // /user/{x}/todos/{x} --// get specific todo per user
    // /user/{x}/todos/{x} --// update specific todo per user
    // /user/{x}/todos/{x} --// delete specific todo per user
    function todoservice($http, $cookies, constants) {
        var url = constants.SERVICE_URL;
        return {
            getTodos: getTodos,
            getTodo: getTodo,
            addTodo: addTodo,
            updateTodo: updateTodo,
            removeTodo: removeTodo
        };
        // read all
        function getTodos(userId) {
            $http.defaults.headers.common.Authorization = $cookies.get('Auth');
            return $http.get(url + 'users/' + userId + '/todos')
                .then(onComplete)
                .catch(onFail);

            function onComplete(response) {
                return response.data;
            }

            function onFail(data) {
                console.log(data.status);
            }
        }
        // read 1
        function getTodo(userId,index) {
            $http.defaults.headers.common.Authorization = $cookies.get('Auth');
            return $http.get(url + 'users/' + userId + '/todos/'+index)
                .then(onComplete)
                .catch(onFail);

            function onComplete(response) {
                return response.data;
            }

            function onFail(data) {
                console.log(data.status);
            }
        }
        // create
        function addTodo(userId, note) {
            $http.defaults.headers.common.Authorization = $cookies.get('Auth');
            return $http.post(url + 'users/' + userId + '/todos', note)
                .then(onComplete)
                .catch(onFail);

            function onComplete(response) {
                return response.data;
            }

            function onFail(data) {
                console.log(data.status);
            }
        }
        // delete
        function removeTodo(userId, noteId) {
            $http.defaults.headers.common.Authorization = $cookies.get('Auth');
            return $http.delete(url + 'users/' + userId + '/todos/' + noteId)
                .then(onComplete)
                .catch(onFail);

            function onComplete(response) {
                return response.data;
            }

            function onFail(data) {
                console.log(data.status);
            }
        }
        // update
        function updateTodo(userId, note) {
            note.user ={id:userId};
            $http.defaults.headers.common.Authorization = $cookies.get('Auth');
            return $http.put(url + 'users/' + userId + '/todos', note)
                .then(onComplete)
                .catch(onFail);

            function onComplete(response) {
                return response.data;
            }

            function onFail(data) {
                console.log(data.status);
            }
        }

    }

})();
