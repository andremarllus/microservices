angular.module('microservices', ['ngRoute'])
	.config(function($routeProvider) {
		$routeProvider.when('/lojas', {
			templateUrl : 'views/main.html',
			controller : 'MainCtrl'
		}).when('/lojas/:id/produtos', {
			templateUrl : 'views/produtos.html',
			controller : 'ProdutosCtrl'
		}).otherwise({
			redirectTo : '/lojas'
		});
	});
