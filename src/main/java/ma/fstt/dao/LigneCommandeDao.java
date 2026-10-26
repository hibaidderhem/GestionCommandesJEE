package ma.fstt.dao;

import ma.fstt.entities.LigneCommande;
import ma.fstt.service.LigneCommandeService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LigneCommandeDao implements LigneCommandeService {

    @Override
    public boolean save(LigneCommande lc) throws SQLException {
        String query = "INSERT INTO ligne_commande (id_commande, id_produit, quantite, prix_unitaire) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, lc.getIdCommande());
            pstmt.setInt(2, lc.getIdProduit());
            pstmt.setInt(3, lc.getQuantite());
            pstmt.setDouble(4, lc.getPrixUnitaire());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean update(LigneCommande lc) throws SQLException {
        String query = "UPDATE ligne_commande SET id_commande = ?, id_produit = ?, quantite = ?, prix_unitaire = ? WHERE id_ligne = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, lc.getIdCommande());
            pstmt.setInt(2, lc.getIdProduit());
            pstmt.setInt(3, lc.getQuantite());
            pstmt.setDouble(4, lc.getPrixUnitaire());
            pstmt.setInt(5, lc.getIdLigne());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(LigneCommande lc) throws SQLException {
        String query = "DELETE FROM ligne_commande WHERE id_ligne = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, lc.getIdLigne());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public LigneCommande findById(int id) throws SQLException {
        String query = "SELECT * FROM ligne_commande WHERE id_ligne = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new LigneCommande(
                        rs.getInt("id_ligne"),
                        rs.getInt("id_commande"),
                        rs.getInt("id_produit"),
                        rs.getInt("quantite"),
                        rs.getDouble("prix_unitaire")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<LigneCommande> findAll() throws SQLException {
        List<LigneCommande> lignes = new ArrayList<>();
        String query = "SELECT * FROM ligne_commande";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                lignes.add(new LigneCommande(
                    rs.getInt("id_ligne"),
                    rs.getInt("id_commande"),
                    rs.getInt("id_produit"),
                    rs.getInt("quantite"),
                    rs.getDouble("prix_unitaire")
                ));
            }
        }
        return lignes;
    }
}