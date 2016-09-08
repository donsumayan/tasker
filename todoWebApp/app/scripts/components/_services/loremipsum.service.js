// Lorem Ipsum Generator/Services
(function() {
    'use strict';
    angular
        .module('todo.components.services')
        .factory('loremipsum', loremipsum);


    function loremipsum($http,$rootScope) {
        return {
            getHeader: header,
            getContent: content
        };

        function header() {
            return $http.get('https://baconipsum.com/api/?type=all-meat&sentences=1&start-with-lorem=1')
                .then(onComplete)
                .catch(onfail);

            function onComplete(response) {
                var header = response.data[0];
                return header;
            }

            function onfail(error) {
                //print errors to console
                console.log('Failed to load data :');
                console.log(error.data);
            }
        }

        function content() {
            return $http.post('https://baconipsum.com/api/?type=meat-and-filler')
                .then(onComplete)
                .catch(onfail);

            function onComplete(response) {
                return response.data[0];
            }

            function onfail(error) {
                //print errors to console
                console.log('Failed to load data :');
                console.log(error.data);
            }
        }
    }

})();
