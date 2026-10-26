package ma.fstt.service;

import ma.fstt.entities.Commande;
import java.sql.SQLException;
import java.util.List;

public interface CommandeService {
    boolean save(Commande commande) throws SQLException;
    boolean update(Commande commande) throws SQLException;
    boolean delete(Commande commande) throws SQLException;
    Commande findById(int id) throws SQLException;
    List<Commande> findAll() throws SQLException;
}