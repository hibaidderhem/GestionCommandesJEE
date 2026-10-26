package ma.fstt.dao;

import ma.fstt.entities.Commande;
import ma.fstt.service.CommandeService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandeDao implements CommandeService {

    @Override
    public boolean save(Commande commande) throws SQLException {
        String query = "INSERT INTO commande (id_client) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, commande.getIdClient());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean update(Commande commande) throws SQLException {
        String query = "UPDATE commande SET id_client = ? WHERE id_commande = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, commande.getIdClient());
            pstmt.setInt(2, commande.getIdCommande());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(Commande commande) throws SQLException {
        String query = "DELETE FROM commande WHERE id_commande = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, commande.getIdCommande());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public Commande findById(int id) throws SQLException {
        String query = "SELECT * FROM commande WHERE id_commande = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Commande(
                        rs.getInt("id_commande"),
                        rs.getTimestamp("date_commande"),
                        rs.getInt("id_client")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Commande> findAll() throws SQLException {
        List<Commande> commandes = new ArrayList<>();
        String query = "SELECT * FROM commande";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                commandes.add(new Commande(
                    rs.getInt("id_commande"),
                    rs.getTimestamp("date_commande"),
                    rs.getInt("id_client")
                ));
            }
        }
        return commandes;
    }
}