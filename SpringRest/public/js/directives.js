'use strict';

angular.module('mongorest.directives', [])
	.directive('authorDisplay', function() {
	  return {		 
		link: function (scope, element, attrs) {
			var authors = scope.book.authors;
			var authorsStr = "";
			for (var i = 0; i < authors.length; i++) {
				authorsStr = authorsStr + authors[i].name;
				if(i+1 < authors.length){
					authorsStr += ', ';
				}
			}
			element.html(authorsStr);
		}
	  };
	});