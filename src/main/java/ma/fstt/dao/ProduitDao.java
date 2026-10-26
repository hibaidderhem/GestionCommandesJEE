package ma.fstt.dao;

import ma.fstt.entities.Produit;
import ma.fstt.service.ProduitService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDao implements ProduitService {

    @Override
    public boolean save(Produit produit) throws SQLException {
        String query = "INSERT INTO produit (nom, prix, quantite_stock) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, produit.getNom());
            pstmt.setDouble(2, produit.getPrix());
            pstmt.setInt(3, produit.getQuantiteStock());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean update(Produit produit) throws SQLException {
        String query = "UPDATE produit SET nom = ?, prix = ?, quantite_stock = ? WHERE id_produit = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, produit.getNom());
            pstmt.setDouble(2, produit.getPrix());
            pstmt.setInt(3, produit.getQuantiteStock());
            pstmt.setInt(4, produit.getIdProduit());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(Produit produit) throws SQLException {
        String query = "DELETE FROM produit WHERE id_produit = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, produit.getIdProduit());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public Produit findById(int id) throws SQLException {
        String query = "SELECT * FROM produit WHERE id_produit = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Produit(
                        rs.getInt("id_produit"),
                        rs.getString("nom"),
                        rs.getDouble("prix"),
                        rs.getInt("quantite_stock")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Produit> findAll() throws SQLException {
        List<Produit> produits = new ArrayList<>();
        String query = "SELECT * FROM produit";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                produits.add(new Produit(
                    rs.getInt("id_produit"),
                    rs.getString("nom"),
                    rs.getDouble("prix"),
                    rs.getInt("quantite_stock")
                ));
            }
        }
        return produits;
    }
}