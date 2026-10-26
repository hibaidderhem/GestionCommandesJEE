package ma.fstt.entities;

public class LigneCommande {
    private int idLigne;
    private int idCommande;
    private int idProduit;
    private int quantite;
    private double prixUnitaire;

    // Constructeur vide
    public LigneCommande() {}

    // Constructeur sans ID
    public LigneCommande(int idCommande, int idProduit, int quantite, double prixUnitaire) {
        this.idCommande = idCommande;
        this.idProduit = idProduit;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }

    // Constructeur complet avec ID
    public LigneCommande(int idLigne, int idCommande, int idProduit, int quantite, double prixUnitaire) {
        this.idLigne = idLigne;
        this.idCommande = idCommande;
        this.idProduit = idProduit;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }

    // Getters et Setters
    public int getIdLigne() { return idLigne; }
    public void setIdLigne(int idLigne) { this.idLigne = idLigne; }

    public int getIdCommande() { return idCommande; }
    public void setIdCommande(int idCommande) { this.idCommande = idCommande; }

    public int getIdProduit() { return idProduit; }
    public void setIdProduit(int idProduit) { this.idProduit = idProduit; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public double getPrixUnitaire() { return prixUnitaire; }
    public void setPrixUnitaire(double prixUnitaire) { this.prixUnitaire = prixUnitaire; }
}