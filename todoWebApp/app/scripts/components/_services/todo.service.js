// To-do Services
(function() {
    'use strict';
    angular
        .module('todo.components.services')
        .factory('todoservice', todoservice);


    function todoservice(globals) {
        return {
            getTodos: todos
        };

        function todos() {
            var todos = [{
                "id": 1,
                "note": "eat healthy",
                "isDone": false,
                "dateCreated": 1473397772000,
                "dateUpdated": 1473397773000
            },{
                "id": 3,
                "note": "exercise",
                "isDone": false,
                "dateCreated": 1473397772000,
                "dateUpdated": 1473397773000
            },{
                "id": 2,
                "note": "Buy groceries",
                "isDone": true,
                "dateCreated": 1473397772000,
                "dateUpdated": 1473397773000
            },];
            return todos;

        }
    }

})();
