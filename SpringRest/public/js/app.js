'use strict';

angular.module('mongorest', [
  'ngAnimate',
  'restangular',
  'ui.router',
  'ui.bootstrap',
  'mongorest.controllers',
  'mongorest.directives'
]).
  config(['$stateProvider', '$urlRouterProvider', 'RestangularProvider', function ($stateProvider, $urlRouterProvider, RestangularProvider) {
    
    $urlRouterProvider.otherwise('/list');

    $stateProvider.state('s_list', {
      url:         '/list',
      templateUrl: 'partials/list.html',
      controller:  'MainCtrl'
    })
    .state('s_add', {
        url:         '/addNewBook',
        templateUrl: 'partials/bookForm.html',
        controller:  'CtrlAddBook'
      })
    .state('s_update', {
        
        templateUrl: 'partials/bookForm.html',
        controller:  'CtrlUpdateBook',
        params:      ['title', 'author', 'category', 'isbn']
      });
  }]).
run(['$log', 'Restangular', '$location', function($log, Restangular, $location) {
    var baseUrl = $location.absUrl();

    var parser = document.createElement('a');
    parser.href = baseUrl;

    $log.debug('Setting Restangular base URL to: ', parser.pathname);
    Restangular.setBaseUrl(parser.pathname + 'service/library/');
  }]);