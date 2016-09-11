// Home component controller
(function() {
    'use strict';
    angular
        .module('todo.components.content')
        .controller('contentController', contentController);

    function contentController($scope, $rootScope, $cookies, globals, todoservice) {
        $rootScope.$emit('updateHeader', 'home');
        var user = $cookies.getObject('user');
        var todoMode = globals.getTodoMode;
        var vm = this;
        var todos = [];
        var insertMode = 'pending';

        vm.runningTasks = 0;
        vm.todos = [];
        vm.sync = sync;
        vm.addNote = addNote;
        if (user) {
            loadTodoList();
        }

        $rootScope.$on('updateTodoList', function(evt, data) {
            insertMode = data;
            vm.todos = _.where(todos, getMode(data));
            addNote();
        });

        vm.removeNote = function(id, index) {
            vm.todos.splice(index, 1);
            if (id) {
                vm.runningTasks++;
                todoservice.removeTodo(user.id, id).then(
                    function() {
                        vm.runningTasks--;
                    }
                );
            }
            addNote();
        };

        vm.editNewNote = function(eform, index) {
            vm.todos[index].note = '';
            eform.$show();
            addNote();
        };

        vm.isDone = function(todo, index) {
            if (todo.isDone) {
                todo.isDone = false;
            } else {
                todo.isDone = true;
            }
            sync(todo, index);
            return todo.isDone;
        };

        function sync(todo, index) {
            if (!vm.todos[index].id) {
                // if todo does not not have an id it means its not yet in db
                // then reload todos
                vm.runningTasks++;
                todoservice.addTodo(user.id, todo).then(
                    function(data) {
                        vm.runningTasks++;
                        todoservice.getTodos(user.id).then(
                            function(data) {
                                todos = data;
                                var nTodo =todos.length-1;
                                vm.todos[nTodo].id = todos[nTodo].id;
                                addNote();
                                vm.runningTasks--;
                            }
                        );
                        vm.runningTasks--;
                    }
                );
            } else {
                // if todo already exist just update
                var id = {
                    id: vm.todos[index].id
                };
                var nTodo = _.findWhere(todos, id);
                vm.runningTasks++;
                todoservice.updateTodo(user.id, nTodo).then(
                    function() {
                        vm.runningTasks--;
                    }
                );
            }
        }

        function loadTodoList() {
            vm.runningTasks++;
            todoservice.getTodos(user.id).then(
                function(data) {
                    todos = data;
                    vm.todos = todos;
                    addNote();
                    vm.runningTasks--;
                }
            );
        }

        function getMode(mode) {
            switch (mode) {
                case 'pending':
                    return {
                        "isDone": false
                    };
                case 'done':
                    return {
                        "isDone": true
                    };
                default:
                    return {};
            }
        }

        function addNote() {
            if (vm.todos.length === 0) {
                vm.todos.push({
                    "isDone": getMode(insertMode).isDone,
                    "note": "Add Note"
                });
            } else {
                if (_.last(vm.todos).note !== "Add Note") {
                    vm.todos.push({
                        "isDone": getMode(insertMode).isDone,
                        "note": "Add Note"
                    });
                }
            }
        }



    }

})();
