(function() {
    'use strict';
    angular
        .module('todo.components.home')
        .controller('homeController', homeController);

    function homeController($scope, $element, $compile) {
        var vm = this;

        vm.name = "HAHA";

    }

})();
