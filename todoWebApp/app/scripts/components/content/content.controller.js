// Home component controller
(function() {
    'use strict';
    angular
        .module('todo.components.content')
        .controller('contentController', contentController);

    function contentController($scope,$rootScope, $mdDialog, globals, todoservice) {
        var vm = this;

        $rootScope.$emit('updateHeader','home');

        vm.cols = 3;
        var todoMode = globals.getTodoMode;
        var todos = todoservice.getTodos();
        vm.todos=todos;
        addNote();

        vm.removeNote = function(index) {
            vm.todos.splice(index, 1);
            addNote();
        };
        vm.addNote = function() {
            addNote();
        };
        vm.editNewNote = function (eform,index) {
          vm.todos[index].note = '';
          eform.$show();
          addNote();
        };
        vm.saveEdit =function (eform,index) {
          console.log(eform);
        };

        $rootScope.$on('updateTodoList',function (evt,data) {
          // console.log(d?ata);
          vm.todos= _.where(todos,getMode(data));
          addNote()
        });

        function getMode(mode) {
          switch (mode) {
            case 'pending':return {"isDone":false};
            case 'done':return {"isDone":true};
            default:return {};
          }
        }

        function addNote(){
          if (_.last(vm.todos).note !== "Add Note") {
              vm.todos.push({
                  "note": "Add Note"
              });
          }
          // console.log(vm.todos);
        }


    }

})();
