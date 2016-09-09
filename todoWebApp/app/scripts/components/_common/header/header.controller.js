// Header module controller
(function() {
    'use strict';
    angular
        .module('todo.components.common.header')
        .controller('headerController', headerController);

    function headerController($scope,userservice) {
        var vm = this;
        vm.header = "Tasker";
        vm.user = userservice.getUser();
        vm.menus= [ "My Todo's", "My Account"];
        vm.selected = vm.menus[0];
        vm.subMenus = ["Pending","Done"];

        vm.switchView = function (menu) {
          if(vm.selected==="My Todo's"){
            vm.subMenus= ["Pending","Done"];
            // $window.location.href= "/#/dashboard";
          }
          else{
            vm.subMenus=  ["Information","Delete Account"];
            // $window.location.href= "/#/user";
          }
            vm.selected=menu;
        }
        // vm.user = user;
    }

})();
