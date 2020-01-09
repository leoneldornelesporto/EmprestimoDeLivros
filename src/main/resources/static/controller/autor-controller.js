app.controller('autor-controller', function($scope, $http) {
    $scope.autoresController = [];
    $scope.autoresControllerCopia = [];
    $scope.autor={"nome":""};

    // Simple GET request example:
    $scope.listarTodos = function(){
        $http({
            method: 'GET',
            url: '/autores'
        }).then(function successCallback(response) {
            $scope.autoresController = response.data;
            $scope.autoresControllerCopia = response.data;
            console.log(response.data);
            console.log(response.status);
        }, function errorCallback(response) {
            console.log(response.data);
            console.log(response.status);
        });
    };

    $scope.listarTodos();


    $scope.salvarAutor = function(){
        $http({
            method: 'POST',
            url: '/autores',
            data:$scope.autor
        }).then(function successCallback(response) {
            $scope.listarTodos();
            console.log(response.data);
            console.log(response.status);
        }, function errorCallback(response) {
            console.log(response.data);
            console.log(response.status);
        });
    };

   $scope.excluirAutor = function(autores){
       $http({
           method: 'DELETE',
           url: '/autores/'+autores.id
       }).then(function successCallback(response) {
           $scope.listarTodos();
           console.log(response.data);
           console.log(response.status);
       }, function errorCallback(response) {
           console.log(response.data);
           console.log(response.status);
       });
   };

    $scope.editarAutor = function(autores){
        $scope.autor = autores;
    };

    $scope.cancelar = function () {
        $scope.autor = {};
        $scope.autoresController = angular.copy($scope.autoresControllerCopia);
    }
});
