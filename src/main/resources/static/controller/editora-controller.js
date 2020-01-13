app.controller("editora-controller",function ($scope, $http) {
    $scope.listEditora=[];
    $scope.listEditoraCopia=[];
    $scope.editora={"nome":""};

    $scope.listarTodos = function(){
        $http({
            method: 'GET',
            url: '/editora'
        }).then(function successCallback(response) {
            $scope.listEditora      = response.data;
            $scope.listEditoraCopia = response.data;
            console.log(response.data);
            console.log(response.status);
        }, function errorCallback(response) {
            console.log(response.data);
            console.log(response.status);
        });
    };

    $scope.listarTodos();

    $scope.saveEditora = function () {
        $http.post('/editora', $scope.editora).then(function (response) {
            $scope.listarTodos();
            console.log(response.status);
            }, function (response) {
            console.log(response.status)
        });
    };

    $scope.editarEditora = function (editoras) {
        $scope.editora = editoras;
    };

    $scope.cancelar = function () {
        $scope.editora={};
        $scope.listEditora = angular.copy($scope.listEditoraCopia);
    };

    $scope.excluirEditora = function (editoras) {
        $http.delete('/editora/'+editoras.id).then(
            function (response) {
                $scope.listarTodos();
                console.log(response.status);
            },
            function (response) {
                console.log(response.status);
            })
    }
});