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
<br/><h1 align="center">Controle de carros</h1><br/>
	<div class="container" ng-app="myApp" ng-controller="customersCtrl">
	<input type="button" class="btn btn-primary" value="Inserir" ng-click="cadastrar()">
	<br/> <br/>
	<table class="table table-haver">
		<tr>
			<td><strong>ID</strong></td>
			<td><strong>Modelo</strong></td>
			<td><strong>Nome</strong></td>
			<td><strong>Opções</strong></td>
		</tr>
		<tr ng-repeat="x in names">
			<td>{{ x.id }}</td>
			<td>{{ x.modelo }}</td>
			<td>{{ x.nome }}</td>
			<td><input type="button" class="btn btn-danger" value="Excluir" ng-click="del(x)"/>
			<input type="button" class="btn btn-warning" value="Alterar" ng-click="selectTo(x)"/></td>
		</tr>
	</table>
</div>
<script>
	var app = angular.module('myApp', []);
	var linkservice = "http://localhost:8080/ProjAngular/REST/carro/";
	app
		.controller(
				'customersCtrl',
				function($scope, $http) {
					$http
						.get(
								linkservice +"select")
						.then(function(response) {
							$scope.names = response.data;
						});
					
					$scope.del = function(car){
						var msg = confirm("tem certeza");
						
						if (msg==true){
							$http.post(linkservice + 'delete', car).then(function(data){
								alert('reg deletado');
								location.reload();
							});	
						}
					}
					
					$scope.selectTo = function(car){
						window.sessionStorage.setItem('car', JSON.stringify(car));
						window.location.href='cadastro.jsp'
					}
				})
</script>
</body>
</html>