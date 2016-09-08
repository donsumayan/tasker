// Home component controller
(function() {
    'use strict';
    angular
        .module('todo.components.content')
        .controller('contentController', contentController);

    function contentController($scope, $mdDialog) {
        var vm = this;
        vm.cols = 3;
        vm.tasks = [];

        vm.content = "Loading data...";

        vm.addNote = function(evt) {

            // if (evt.code === "Enter") {
                console.log();
                vm.tasks.push({
                    todo:vm.newTodo ? vm.newTodo:"none"
                });
                vm.newTodo = "";
            // }
            console.log("tasks: "+vm.tasks.length);
            // return todo;
        };
        vm.something = "this is something";
        vm.addDialog = function(ev) {
            // $mdDialog.show({
            //         controller: 'contentController',
            //         controllerAs:'vm',
            //         templateUrl: 'scripts/components/content/content.dialog.tmpl.html',
            //         parent: angular.element(document.body),
            //         targetEvent: ev,
            //         clickOutsideToClose: true,
            //         fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
            //     })
            //     .then(function(answer) {
            //         $scope.status = 'You said the information was "' + answer + '".';
            //     }, function() {
            //         $scope.status = 'You cancelled the dialog.';
            //     });
        };
    }

})();
