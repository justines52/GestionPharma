package gestpharma.gestpharma.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Facture {
    private String ID_facture;
    private LocalDate date_facture;
    private String ID_fournisseur;
    private ArrayList<Commande> commandes = new ArrayList<>();

    public Facture() {}

    public Facture (String ID_facture, LocalDate date_facture,String ID_fournisseur) {
        this.ID_facture = ID_facture;
        this.date_facture = date_facture;
        this.ID_fournisseur = ID_fournisseur;
        this.commandes = new ArrayList<>();
    }

    public void addCommande(Commande commande) {commandes.add(commande);}

    public void removeCommande(Commande commande) {commandes.remove(commande);}

    //getters

    public String getID_facture() {return ID_facture;}
    public LocalDate getDate_sortie() {return date_facture;}
    public String getID_fournisseur() {return ID_fournisseur;}
    public ArrayList<Commande> getCommandes() {return commandes;}

    //setters

    public void setID_facture(String ID_facture) {this.ID_facture = ID_facture;}
    public void setDate_sortie(LocalDate date_facture) {this.date_facture = date_facture;}
    public void setCommandes(ArrayList<Commande> commandes) {this.commandes = commandes;}
}
