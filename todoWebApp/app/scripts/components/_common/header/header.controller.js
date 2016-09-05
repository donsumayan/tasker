(function() {
    'use strict';
    angular
        .module('todo.components.common.header')
        .controller('headerController', headerController);

    function headerController($scope, $element, $compile) {
      var vm=this;

      vm.message="this is the header";

    }

})();
