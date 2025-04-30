package gestpharma.gestpharma.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Commande {
    private String ID_commande;
    private LocalDate date_commande;
    private String ID_produit;
    private int ID_preparateur;
    private Produit produit;


    public Commande() {}
    public Commande(String ID_commande, LocalDate date_commande, Produit produit, int ID_preparateur) {
        this.ID_commande = ID_commande;
        this.date_commande = date_commande;
        this.produit = produit;
        this.ID_produit = (produit != null) ? produit.getID_produit() : null;
        this.ID_preparateur = ID_preparateur;
    }


    //getters

    public String getID_commande() {return ID_commande;}
    public LocalDate getDate_commande() {return date_commande;}
    public Produit getProduit() {return produit;}
    public int getID_preparateur() {return ID_preparateur;}
    public String getID_produit() {
        return ID_produit;
    }

    //setters

    public void setID_commande(String ID_commande) {this.ID_commande = ID_commande;}
    public void setDate_commande(LocalDate date_commande) {this.date_commande = date_commande;}
    public void setProduit(Produit produit) {
        this.produit = produit;
        this.ID_produit = (produit != null) ? produit.getID_produit(): null;
    }
    public void setID_preparateur(int ID_preparateur) { this.ID_preparateur = ID_preparateur; }
}
