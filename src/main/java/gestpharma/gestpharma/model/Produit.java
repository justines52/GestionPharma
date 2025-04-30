package gestpharma.gestpharma.model;

public class Produit {

    private String ID_produit;
    private double prix_unitaire;

    public Produit() {}
    public Produit(String ID_produit, double prix_unitaire) {
        this.ID_produit = ID_produit;
        this.prix_unitaire = prix_unitaire;
    }

    //getters

    public String getID_produit() {return ID_produit;}
    public double getPrix_unitaire() {return prix_unitaire;}

    //setters

    public void setID_produit(String ID_produit) {this.ID_produit = ID_produit;}
    public void setPrix_unitaire(double prix_unitaire) {this.prix_unitaire = prix_unitaire;}
}
