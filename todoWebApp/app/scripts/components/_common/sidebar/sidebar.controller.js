(function() {
    'use strict';
    angular
        .module('todo.components.common.sidebar')
        .controller('sidebarController', sidebarController);

    function sidebarController($scope, $element, $compile, $mdDialog) {
        var vm = this;
        vm.showAdvanced = function(ev) {
            $mdDialog.show({
                    templateUrl: 'scripts/components/_common/sidebar/sidebar.tmpl.html',
                    parent: angular.element(document.body),
                    targetEvent: ev,
                    clickOutsideToClose: true,
                    fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                })
                .then(function(answer) {
                    $scope.status = 'You said the information was "' + answer + '".';
                }, function() {
                    $scope.status = 'You cancelled the dialog.';
                });
        };
    }

})();
