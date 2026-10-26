package ma.fstt.dao;

import ma.fstt.entities.Client;
import ma.fstt.service.ClientService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao implements ClientService {

    @Override
    public boolean save(Client client) throws SQLException {
        String query = "INSERT INTO client (nom, prenom, email, telephone) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, client.getNom());
            pstmt.setString(2, client.getPrenom());
            pstmt.setString(3, client.getEmail());
            pstmt.setString(4, client.getTelephone());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean update(Client client) throws SQLException {
        String query = "UPDATE client SET nom = ?, prenom = ?, email = ?, telephone = ? WHERE id_client = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, client.getNom());
            pstmt.setString(2, client.getPrenom());
            pstmt.setString(3, client.getEmail());
            pstmt.setString(4, client.getTelephone());
            pstmt.setInt(5, client.getIdClient());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(Client client) throws SQLException {
        String query = "DELETE FROM client WHERE id_client = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, client.getIdClient());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public Client findById(int id) throws SQLException {
        String query = "SELECT * FROM client WHERE id_client = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Client(
                        rs.getInt("id_client"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("telephone")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Client> findAll() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM client";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                clients.add(new Client(
                    rs.getInt("id_client"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("email"),
                    rs.getString("telephone")
                ));
            }
        }
        return clients;
    }
}