<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<script src="angularjs/angular.min.js"></script>
<link rel="stylesheet" type="text/css"
href="bootstrap/css/bootstrap.css">

<body>
	<br />
	<br />
	<h1 align="center">Controle de carros</h1>
	<br />
	<div class="form" ng-ap="myCar" ng-controller="carFormController">
	<div>
		<form name="carForm">
			<div class="container">
				<div class="form-group">
					<label for="nome">Nome</label><input id="nome" name="nome" type="text" class="form-control" maxlenght="50"
					ng-model="car.nome" required ng-minlenght="2" ng-maxlenght="50"/>
				<br /><label for="modelo">Modelo</label> <input id="modelo" name="" modelo="" type="text" class="form-control"
				maxlenght="50" ng-model="car.modelo" required ng-minlenght="2" ng-maxlenght="50"/>
				</div>
				<div class="buttons">
					<button ng-click="save()" class="btn btn-primary">Salvar</button>
					<button ng-click="voltar()" class="btn btn-default">Voltar</button>	 
				</div>
			</div>
		</form>
	</div>
	</div>
<script>
	var app = angular.module('myApp', []);
	var linkservice = "http://localhost:8080/ProjAngular/REST/carro/";
	
	app.controller('customersCtrl',function($scope, $http) {
		$scope.car = JSON.parse(window.sessionStorage.getItem('car'));
		$scope.save = function(){
			if(!$scope.car.id){
				$http.post(linkservice + 'save', $scope.car).then(function(data) {
					alert('Registro inserido!');
					window.location = "index.jsp";
				});
			}else {
				$http.post(linkservice + 'update', $scope.car).then(function(data) {
					alert('Registro alterado!');
					window.location = "index.jsp";
			});
		}
	};
	$scope.voltar = function(){
		window.location = "index.jsp";
	}
	});
</script>

</body>
</html>