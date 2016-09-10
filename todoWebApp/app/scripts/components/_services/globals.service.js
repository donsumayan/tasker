// User Services
(function() {
    'use strict';
    angular
        .module('todo.components.services')
        .factory('globals', globalsservice);


    function globalsservice(userservice) {
        var state;
        var todoMode;
        var user;
        return {
            getUser: this.user,
            setUser: setUser,
            getTodoMode: this.todoMode,
            setTodoMode: setTodoMode,
            getState: !this.state? 'home':this.state,
            setState: setState
        };

        function setState(newState) {
          this.state=newState;
        };
        function setTodoMode(newMode) {
          this.todoMode=newMode;
        };

        function setUser() {
            this.user = {
                "id":1,
                "first_name": "don",
                "last_name": "sumayan",
                "email": "don.sumayan@gmail.com",
                "role_id": "1"
            };

        }
    }

})();
