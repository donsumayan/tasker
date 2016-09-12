(function() {
    'use strict';
    angular
        .module('todo.components.admin')
        .controller('adminController', adminController);

    function adminController($scope,$rootScope, $state, $cookies,$filter, userservice,todoservice) {
        $rootScope.$emit('updateHeader', 'admin');
        var vm = this;
        var user = $cookies.getObject('user');
        vm.user=user;
        
        if(user.role.id===1){
            // countTodos();
            userservice.getUsers().then(
                function (data) {
                    vm.users=data;
                }
            );
        }
        else{
            $state.go('main-default.home');
        }

        vm.admin = user;
        vm.users = [];
        vm.todoCount = 0;
        vm.roles = [
          {id:1,name:"Admin"},
          {id:2,name:"User"}
        ];

        

        vm.setAdmin = function(index) {
            if (vm.users[index].role.id===1) {
                vm.users[index].role.id=2;
            }
            else{
                vm.users[index].role.id=1;
            }
            userservice.toggleAdministrator(vm.users[index]);
        };

        vm.removeUser = function(id, index) {
            if (user.id!==id) {
                vm.users[index].removing=true;
                userservice.deleteUser(id).then(
                    function(data) {
                        if (data.status===200) {
                            vm.users.splice(index, 1);
                        }

                        vm.users[index].removing=false;

                    }
                );
            }       
        };

        function countTodos() {
            todoservice.getAllTodos().then(
                function(data) {
                    vm.todoCount=data.length;
                }
            );
        }
    }

})();
