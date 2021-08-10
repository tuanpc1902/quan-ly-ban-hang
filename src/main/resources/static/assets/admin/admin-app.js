app = angular.module("admin-app", ["ngRoute"]);
app.config(function ($routeProvider) {
    $routeProvider
        .when("/product", {
            templateUrl: "/assets/admin/product/index.html",
            controller: "product-ctrl"
        })
        .when("/order", {
            templateUrl: "/assets/admin/order/index.html",
            controller: "order-ctrl"
        })
        .when("/category", {
            templateUrl: "/assets/admin/category/index.html",
            controller: "category-ctrl"
        })
        .when("/account", {
            templateUrl: "/assets/admin/account/index.html",
            controller: "account-ctrl"
        })
        .when("/authorize", {
            templateUrl: "/assets/admin/authority/index.html",
            controller: "authority-ctrl"
        })
        .when("/unauthorized", {
            templateUrl: "/assets/admin/authority/unauthorized.html",
            controller: "authority-ctrl"
        })
        .otherwise({
            template: "<h1 class='text-center'>SHOPEE Administration</h1>"
        })
})


$(document).ready(function () {
    $(".tab").click(function () {
        if (!$(this).hasClass('active')) {
            $(".tab.active").removeClass("active");
            $(this).addClass("active");
        }
    });
});