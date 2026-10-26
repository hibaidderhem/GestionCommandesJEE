<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Clients</title>
    <!-- Bootstrap pour un design propre rapidement -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h2 class="mb-4">Espace Client - Liste des Clients</h2>

    <!-- Formulaire d'ajout / modification -->
    <div class="card mb-4 p-3 shadow-sm">
        <h4>Ajouter un Client</h4>
        <form action="ClientServlet" method="post">
            <div class="row g-3">
                <div class="col-md-3">
                    <input type="text" name="nom" class="form-control" placeholder="Nom" required>
                </div>
                <div class="col-md-3">
                    <input type="text" name="prenom" class="form-control" placeholder="Prénom" required>
                </div>
                <div class="col-md-3">
                    <input type="email" name="email" class="form-control" placeholder="Email" required>
                </div>
                <div class="col-md-3">
                    <input type="text" name="telephone" class="form-control" placeholder="Téléphone" required>
                </div>
            </div>
            <button type="submit" class="btn btn-success mt-3">Enregistrer</button>
        </form>
    </div>

    <!-- Tableau de la liste des clients -->
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Email</th>
                <th>Téléphone</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="client" items="${clients}">
                <tr>
                    <td>${client.idClient}</td>
                    <td>${client.nom}</td>
                    <td>${client.prenom}</td>
                    <td>${client.email}</td>
                    <td>${client.telephone}</td>
                    <td>
                        <a href="ClientServlet?action=delete&id=${client.idClient}" class="btn btn-danger btn-sm" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce client ?');">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="index.jsp" class="btn btn-secondary mt-3">Retour à l'accueil</a>
</body>
</html>