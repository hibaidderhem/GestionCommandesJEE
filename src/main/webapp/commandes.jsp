<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Commandes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h2 class="mb-4">Espace Commande - Liste des Commandes</h2>

    <!-- Formulaire d'ajout -->
    <div class="card mb-4 p-3 shadow-sm">
        <h4>Créer une Commande</h4>
        <form action="CommandeServlet" method="post">
            <div class="row g-3">
                <div class="col-md-6">
                    <label for="idClient" class="form-label">Sélectionner un Client (ID)</label>
                    <input type="number" name="idClient" class="form-control" placeholder="Entrez l'ID du client" required>
                </div>
            </div>
            <button type="submit" class="btn btn-success mt-3">Créer la commande</button>
        </form>
    </div>

    <!-- Tableau de la liste des commandes -->
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
                <th>ID Commande</th>
                <th>Date de Commande</th>
                <th>ID Client</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cmd" items="${commandes}">
                <tr>
                    <td>${cmd.idCommande}</td>
                    <td>${cmd.dateCommande}</td>
                    <td>${cmd.idClient}</td>
                    <td>
                        <a href="CommandeServlet?action=delete&id=${cmd.idCommande}" class="btn btn-danger btn-sm" onclick="return confirm('Supprimer cette commande ?');">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="index.jsp" class="btn btn-secondary mt-3">Retour à l'accueil</a>
</body>
</html>