package ma.fstt.service;

import ma.fstt.entities.LigneCommande;
import java.sql.SQLException;
import java.util.List;

public interface LigneCommandeService {
    boolean save(LigneCommande ligneCommande) throws SQLException;
    boolean update(LigneCommande ligneCommande) throws SQLException;
    boolean delete(LigneCommande ligneCommande) throws SQLException;
    LigneCommande findById(int id) throws SQLException;
    List<LigneCommande> findAll() throws SQLException;
}