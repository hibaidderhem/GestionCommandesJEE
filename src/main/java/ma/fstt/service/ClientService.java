package ma.fstt.service;

import ma.fstt.entities.Client;
import java.sql.SQLException;
import java.util.List;

public interface ClientService {
    boolean save(Client client) throws SQLException;
    boolean update(Client client) throws SQLException;
    boolean delete(Client client) throws SQLException;
    Client findById(int id) throws SQLException;
    List<Client> findAll() throws SQLException;
}