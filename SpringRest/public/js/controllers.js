'use strict';

angular.module('mongorest.controllers', [])
  .controller('MainCtrl', ['$scope', '$rootScope', '$log', '$state', 'Restangular', function($scope, $rootScope, $log, $state, Restangular) {
    $log.debug('MainCtrl controller fired.');
    Restangular.all('list').getList().then(function(body) {
  	  $scope.bookList = body;
  	  $log.debug('books retrieved  = ' + $scope.bookList.length);
	});
	
	$scope.selectedBook = null;
	
	$scope.showAddForm = function(){
		$state.go('s_add');
	};
	
	$scope.deleteBook = function(){
		Restangular.one("delete").customDELETE($scope.selectedBook).then(function() {
		  $log.debug('refreshing list');
	  	  $state.go('s_list');
		});
	};
	
	$scope.selectBook = function(book){
	  $state.go('s_update', book);
	};
  }])
	.controller('CtrlAddBook', ['$scope', '$rootScope', '$log', '$state', 'Restangular', function($scope, $rootScope, $log, $state, Restangular) {
    $log.debug('CtrlAddBook controller fired.');
    $scope.book = {title: null, authors: [], category: null, isbn: null};
    
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
  .controller('CtrlUpdateBook', ['$scope', '$rootScope', '$log', '$state', '$stateParams', 'Restangular', function($scope, $rootScope, $log, $state, $stateParams, Restangular) {
    $log.debug('CtrlUpdateBook controller fired with params ' + $stateParams.title);
     
    $scope.book = $stateParams;
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
 