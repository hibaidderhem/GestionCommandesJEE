package ma.fstt.entities;

import java.util.Date;

public class Commande {
    private int idCommande;
    private Date dateCommande;
    private int idClient;

    // Constructeur vide
    public Commande() {}

    // Constructeur sans ID (pour l'insertion)
    public Commande(int idClient) {
        this.idClient = idClient;
    }

    // Constructeur complet avec ID et Date
    public Commande(int idCommande, Date dateCommande, int idClient) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.idClient = idClient;
    }

    // Getters et Setters
    public int getIdCommande() { return idCommande; }
    public void setIdCommande(int idCommande) { this.idCommande = idCommande; }

    public Date getDateCommande() { return dateCommande; }
    public void setDateCommande(Date dateCommande) { this.dateCommande = dateCommande; }

    public int getIdClient() { return idClient; }
    public void setIdClient(int idClient) { this.idClient = idClient; }
}