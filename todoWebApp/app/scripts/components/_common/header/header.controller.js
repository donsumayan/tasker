// Header module controller
(function() {
    'use strict';
    angular
        .module('todo.components.common.header')
        .controller('headerController', headerController);

    function headerController($scope, $location, userservice) {
        var vm = this;
        vm.header = "Tasker";
        vm.user = userservice.getUser();
        vm.menus = [{
            title: "My Todo's",
            sref: "main-default.home",
            subs: ["All", "Done", "Pending"]
        }, {
            title: "My Account",
            sref: "main-default.user",
            subs: ["All", "Done", "Pending"]
        }];
        vm.selected = vm.menus[0];
        vm.subMenus = ["All", "Done", "Pending"];

        vm.switchView = function(view) {
                $location.path(view)
                switch (view) {
                    case vm.menus[0].title:
                        vm.selected = vm.menus[0];
                        console.log("selected view :"+vm.selected);
                        break;
                    case vm.menus[1].title:
                        vm.selected = vm.menus[1];
                        console.log("selected view :"+vm.selected);
                        break;
                    default:
                        console.log('default');
                        break;
                }
            }
            // vm.user = user;
    }

})();
