package gestpharma.gestpharma.model;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class Commande {
    private String ID_commande;
    private LocalDateTime date_commande;
    private ArrayList<Produit> produits = new ArrayList<>();

    public Commande() {}
    public Commande(String ID_commande, LocalDateTime date_commande) {
        this.ID_commande = ID_commande;
        this.date_commande = date_commande;
    }

    public void addProduit(Produit produit) {
        produits.add(produit);
    }
    public void removeProduit(Produit produit) {
        produits.remove(produit);
    }

    //getters

    public String getID_commande() {
        return ID_commande;
    }
    public LocalDateTime getDate_commande() {
        return date_commande;
    }
    public ArrayList<Produit> getProduits() {
        return produits;
    }

    //setters

    public void setID_commande(String ID_commande) {
        this.ID_commande = ID_commande;
    }
    public void setDate_commande(LocalDateTime date_commande) {
        this.date_commande = date_commande;
    }
    public void setProduits(ArrayList<Produit> produits) {
        this.produits = produits;
    }

}
