// Sidebar module controller
(function() {
    'use strict';
    angular
        .module('todo.components.common.sidebar')
        .controller('sidebarController', sidebarController);

    function sidebarController($scope, $element, $compile) {
        var vm = this;

        vm.addNote = function ($scope) {
            // loremipsum.getContent().then(
            //     function (data) {
            //         console.log(data);
            //         var divElement = angular.element(document.querySelector('.content'));
            //         var appendHtml = $compile('<div flex>'+data+'</div>')($scope);
            //         divElement.append(appendHtml);
            //     }
            // );
        };
    }

})();
