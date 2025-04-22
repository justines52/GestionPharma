package gestpharma.gestpharma.model;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class Facture {
    private String ID_facture;
    private LocalDateTime date_sortie;
    private ArrayList<Commande> commandes = new ArrayList<>();

    public Facture() {}

    public Facture (String ID_facture, LocalDateTime date_sortie) {
        this.ID_facture = ID_facture;
        this.date_sortie = date_sortie;
    }

    public void addCommande(Commande commande) {
        commandes.add(commande);
    }

    public void removeCommande(Commande commande) {
        commandes.remove(commande);
    }

    //getters

    public String getID_facture() {
        return ID_facture;
    }
    public LocalDateTime getDate_sortie() {
        return date_sortie;
    }
    public ArrayList<Commande> getCommandes() {
        return commandes;
    }

    //setters

    public void setID_facture(String ID_facture) {
        this.ID_facture = ID_facture;
    }
    public void setDate_sortie(LocalDateTime date_sortie) {
        this.date_sortie = date_sortie;
    }
    public void setCommandes(ArrayList<Commande> commandes) {
        this.commandes = commandes;
    }

}
