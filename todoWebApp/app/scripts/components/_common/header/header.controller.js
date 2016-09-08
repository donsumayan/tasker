// Header module controller
(function() {
    'use strict';
    angular
        .module('todo.components.common.header')
        .controller('headerController', headerController);

    function headerController($scope, $element, $compile) {
        var vm = this;
        vm.header = "Tasker";
        var user = {
            name: "don"
        }
        // vm.user = user;
    }

})();
