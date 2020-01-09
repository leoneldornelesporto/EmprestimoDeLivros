var app = angular.module("myApp", ["ngRoute"]);

app.config(function($routeProvider, $locationProvider) {
    $routeProvider
        .when("/", {
            templateUrl : "view/telaAutor/autor.html",
            controller:"autor-controller"
        })
        .when("/listaAutor", {
            templateUrl : "view/telaAutor/listaAutor.html",
            controller:"autor-controller"
        })
        .when("/detalheAutor/:detalheAutorId", {
            templateUrl : "view/telaAutor/detalheAutor.html",
            controller:"autor-detalhe-controller"
        })
        .when("/editora", {
            templateUrl : "view/telaEditora/editora.html"
        })
        .when("/usuario", {
            templateUrl : "view/telaUsuario/usuario.html"
        }).otherwise({
        redirectTo:'/'
    });

    $locationProvider.html5Mode(true);
});

