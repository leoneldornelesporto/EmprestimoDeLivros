app.controller("autor-detalhe-controller",function ($scope,$routeParams,$http) {
    $scope.autorDetalhe={};

    $http.get('autores/'+$routeParams.detalheAutorId).then(function (response) {
        $scope.autorDetalhe = response.data;
    }, function (response) {
        console.log(response);
    });
});