// Home component controller
(function() {
    'use strict';
    angular
        .module('todo.components.content')
        .controller('contentController', contentController);

    function contentController($scope, $mdDialog, todoservice) {
        var vm = this;
        vm.cols = 3;
        vm.todos = todoservice.getTodos();
        vm.todos.push({
            "id": 1,
            "title": null,
            "note": "Add Note",
            "isDone": null
        });
        vm.removeNote = function(index) {
            vm.todos.splice(index, 1);
            addNote();
        };
        vm.addNote = function() {
            addNote();
            console.log(vm.todos);
        }
        vm.editNewNote = function (eform,index) {
          vm.todos[index].note = '';
          eform.$show();
          addNote();
        }
        vm.saveEdit =function (eform,index) {
          console.log(eform);
        }
        function addNote(){
          if (_.last(vm.todos).note !== "Add Note") {
              vm.todos.push({
                  "note": "Add Note"
              });
          }
        }


    }

})();
