/** 
 * Angular bootstrap 
 *  https://docs.angularjs.org/api referencias para diretivas usadas
 */
angular.module('App', [])
.controller('Item', ItemCtrl);

// Controlador de item
function ItemCtrl($scope, $http){

  // Inicia nossa lista de itens
  $scope.itens = [];

  // Adiciona o item dentro da lista 
  $scope.adicionar = function(item){
    $scope.itens.push({ name : item });
    // Limpa o valor digitado no campo
    $scope.item = '';

    // Envia para o servidor o novo item
    $http({
			method: 'POST',
			url: "inserir", // url = /server_example/inserir
			headers: {'Content-Type': 'application/json'},
			data : { item : item },
		}).then(
      function successCallback(response) {
        console.log(response);
      },
      function errorCallback(response){
      }
    );
  }

  $scope.listar = function(){
    // Recupera a lista de itens
    $http({
			method: 'GET',
			url: "listar", // url = /server_example/listar
		}).then(
      function successCallback(response) {
        console.log(response);
        // Se a lista de itens existe
        if(response.data)
          $scope.itens = response.data.itens; // Adiciona a lista no escopo da controladora
      },
      function errorCallback(response){
      }
    );
  }
}

(function($){
  $(function(){

    $('.button-collapse').sideNav();
    $('.parallax').parallax();

  }); // end of document ready
})(jQuery); // end of jQuery name space