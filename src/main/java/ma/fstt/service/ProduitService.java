package ma.fstt.service;

import ma.fstt.entities.Produit;
import java.sql.SQLException;
import java.util.List;

public interface ProduitService {
    boolean save(Produit produit) throws SQLException;
    boolean update(Produit produit) throws SQLException;
    boolean delete(Produit produit) throws SQLException;
    Produit findById(int id) throws SQLException;
    List<Produit> findAll() throws SQLException;
}