// directive for appending cards
(function() {
    'use strict';
    angular
        .module('todo.components.directives')
        .directive('appendCard', appendCard);

    function appendCard($compile, loremipsum) {
        var vm = this;
        return function(scope, element, attrs) {
            element.bind("click", function() {
                //call loremipsum service
                loremipsum.getContent().then(
                    function (data) {
                        var divElement = angular.element(document.querySelector('.cards'));
                        var appendHtml = $compile('<div flex class="card">'+data+'</div>')(scope);
                        divElement.append(appendHtml);
                    }
                );

            });
        };
    }
})();
