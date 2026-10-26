<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Commandes - Accueil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5 text-center">
    <div class="p-5 mb-4 bg-light rounded-3 shadow-sm">
        <h1 class="display-5 fw-bold">Application de Gestion des Commandes</h1>
        <p class="col-md-8 fs-4 mx-auto">Projet JEE - Architecture MVC (Servlets, JSP, JDBC, MySQL)</p>
        
        <div class="mt-4">
            <a href="ClientServlet" class="btn btn-primary btn-lg m-2">Espace Clients</a>
            <a href="ProduitServlet" class="btn btn-warning btn-lg m-2">Espace Produits</a>
            <a href="CommandeServlet" class="btn btn-success btn-lg m-2">Espace Commandes</a>
        </div>
    </div>
</body>
</html>