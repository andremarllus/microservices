angular.module('microservices')
	.controller('ProdutosCtrl', function($scope, $http, $routeParams) {
		$http({
			method : 'GET',
			url : '/produtos/lojas/' + $routeParams.id
		}).then(function(response) {
			$scope.produtos = response.data;
		}, function(response) {
			console.error('Erro requisitando produtos.')
		});
	});