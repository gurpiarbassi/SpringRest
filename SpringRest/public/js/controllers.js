'use strict';

angular.module('mongorest.controllers', [])
  .controller('MainController', ['$scope', '$rootScope', '$log', '$state', 'Restangular', function($scope, $rootScope, $log, $state, Restangular) {
    $log.debug('MainController fired.');
    Restangular.all('list').getList().then(function(body) {
  	  $scope.bookList = body;
  	  $log.debug('books retrieved  = ' + $scope.bookList.length);
	});
	
	$scope.selectedBook = null;
	
	$scope.showAddForm = function(){
		$state.go('s_add');
	};
	
	$scope.deleteBook = function(){
		Restangular.one("book", $scope.selectedBook).remove().then(function() {
		$log.debug('refreshing list');
	  	$state.go($state.current, {}, {reload: true});
	  });
	};
	
	$scope.selectBook = function(isbn){
	  $state.go('s_update', {'isbn':isbn});
	};
  }])
	.controller('AddBookController', ['$scope', '$rootScope', '$log', '$state', 'Restangular', function($scope, $rootScope, $log, $state, Restangular) {
    $log.debug('AddBookController controller fired.');
    $scope.book = {title: null, authors: [{name:''}], category: null, isbn: null};
    
    
    $scope.addAuthor = function () {
      $scope.book.authors.push({name:''});
    };
    
    $scope.removeAuthor = function (index) {
      $scope.book.authors.splice(index, 1);
    };
    
    $scope.goBack = function(){
		$state.go('s_list');
	};
	
	$scope.saveBook = function(){
		Restangular.all('addBook').post($scope.book).then(function(body) {
	  	  var savedBook = body;
	  	  $log.debug('book saved  = ' + savedBook);
	  	  $state.go('s_list');
		});		
	};	
  }])
  .controller('UpdateBookController', ['$scope', '$rootScope', '$log', '$state', '$stateParams', 'Restangular', function($scope, $rootScope, $log, $state, $stateParams, Restangular) {
    $log.debug('UpdateBookController controller fired with params ' + angular.toJson($stateParams, true));
     
    
    //1 retrieve the book via rest
    Restangular.one('getBook', $stateParams.isbn).get().then(function(body) {
    	  $scope.book = body;
      	  $log.debug('book retrieved  = ' + $scope.book);
    	});
    
    $scope.addAuthor = function () {
        $scope.book.authors.push({name:''});
    };
      
    $scope.removeAuthor = function (index) {
       $scope.book.authors.splice(index, 1);
    };
    
    $scope.goBack = function(){
		$state.go('s_list');
	};
	
	$scope.saveBook = function(){
		Restangular.all('addBook').post($scope.book).then(function(body) {
	  	  var savedBook = body;
	  	  $log.debug('book saved  = ' + savedBook);
	  	  $state.go('s_list');
		});		
	};	
  }]);
 