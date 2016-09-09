// To-do Services
(function() {
    'use strict';
    angular
        .module('todo.components.services')
        .factory('todoservice', todoservice);


    function todoservice() {
        return {
            getTodos: todos
        };

        function todos() {
            var todos = [{
                "id": 1,
                "note": "Just do it!",
                "isDone": false,
                "dateCreated": 1473397772000,
                "dateUpdated": 1473397773000
            }];

            return todos;

        }
    }

})();
