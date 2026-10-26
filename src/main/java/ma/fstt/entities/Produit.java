package ma.fstt.entities;

public class Produit {
    private int idProduit;
    private String nom;
    private double prix;
    private int quantiteStock;

    // Constructeur vide
    public Produit() {}

    // Constructeur sans ID (pour l'ajout)
    public Produit(String nom, double prix, int quantiteStock) {
        this.nom = nom;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
    }

    // Constructeur complet avec ID
    public Produit(int idProduit, String nom, double prix, int quantiteStock) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
    }

    // Getters et Setters
    public int getIdProduit() { return idProduit; }
    public void setIdProduit(int idProduit) { this.idProduit = idProduit; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public int getQuantiteStock() { return quantiteStock; }
    public void setQuantiteStock(int quantiteStock) { this.quantiteStock = quantiteStock; }
}