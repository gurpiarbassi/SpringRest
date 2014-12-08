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
  }])
	.controller('CtrlAddBook', ['$scope', '$rootScope', '$log', '$state', 'Restangular', function($scope, $rootScope, $log, $state, Restangular) {
    $log.debug('CtrlAddBook controller fired.');
    $scope.newBook = {title: null, author: null, category: null, isbn: null};
    
    $scope.goBack = function(){
		$state.go('s_list');
	};
	
	$scope.addBook = function(){
		Restangular.all('addBook').post($scope.newBook).then(function(body) {
	  	  var savedBook = body;
	  	  $log.debug('book saved  = ' + savedBook);
	  	  $state.go('s_list');
		});		
	};	
  }])
  .controller('CtrlUpdateBook', ['$scope', '$rootScope', '$log', '$state', 'Restangular', function($scope, $rootScope, $log, $state, Restangular) {
    $log.debug('CtrlUpdateBook controller fired.');
    
    
    $scope.goBack = function(){
		$state.go('s_list');
	};
	
	$scope.updateBook = function(){
		Restangular.all('addBook').post($scope.newBook).then(function(body) {
	  	  var savedBook = body;
	  	  $log.debug('book saved  = ' + savedBook);
	  	  $state.go('s_list');
		});		
	};	
  }]);
 