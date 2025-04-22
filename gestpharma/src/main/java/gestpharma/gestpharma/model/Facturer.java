package gestpharma.gestpharma.model;

public class Facturer {
    private String ID_commande;
    private String ID_facture;

    public Facturer(){}

    public Facturer(Commande commande, Facture facture) {
        this.ID_commande = commande.getID_commande();
        this.ID_facture = facture.getID_facture();
    }

    //getters

    public String getID_commande() {
        return ID_commande;
    }
    public String getID_facture() {
        return ID_facture;
    }

    //setters

    public void setID_commande(String ID_commande) {
        this.ID_commande = ID_commande;
    }
    public void setID_facture(String ID_facture) {
        this.ID_facture = ID_facture;
    }
}
