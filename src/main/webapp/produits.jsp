<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Produits</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h2 class="mb-4">Espace Produit - Liste des Produits</h2>

    <!-- Formulaire d'ajout -->
    <div class="card mb-4 p-3 shadow-sm">
        <h4>Ajouter un Produit</h4>
        <form action="ProduitServlet" method="post">
            <div class="row g-3">
                <div class="col-md-4">
                    <input type="text" name="nom" class="form-control" placeholder="Nom du produit" required>
                </div>
                <div class="col-md-4">
                    <input type="number" step="0.01" name="prix" class="form-control" placeholder="Prix" required>
                </div>
                <div class="col-md-4">
                    <input type="number" name="quantiteStock" class="form-control" placeholder="Quantité en stock" required>
                </div>
            </div>
            <button type="submit" class="btn btn-success mt-3">Enregistrer</button>
        </form>
    </div>

    <!-- Tableau de la liste des produits -->
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Prix</th>
                <th>Stock</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="produit" items="${produits}">
                <tr>
                    <td>${produit.idProduit}</td>
                    <td>${produit.nom}</td>
                    <td>${produit.prix} DH</td>
                    <td>${produit.quantiteStock}</td>
                    <td>
                        <a href="ProduitServlet?action=delete&id=${produit.idProduit}" class="btn btn-danger btn-sm" onclick="return confirm('Supprimer ce produit ?');">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="index.jsp" class="btn btn-secondary mt-3">Retour à l'accueil</a>
</body>
</html>