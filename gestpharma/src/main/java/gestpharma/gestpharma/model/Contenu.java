package gestpharma.gestpharma.model;

public class Contenu {
    private String ID_Lot;
    private String ID_Produit;

    public Contenu() {}
    public Contenu(Lot lot, Produit produit) {
        this.ID_Lot = lot.getID_Lot();
        this.ID_Produit = produit.getID_Produit();
    }

    //getters

    public String getID_Lot() {
        return ID_Lot;
    }
    public String getID_Produit() {
        return ID_Produit;
    }

    //setters

    public void setID_Lot(String ID_Lot) {
        this.ID_Lot = ID_Lot;
    }
    public void setID_Produit(String ID_Produit) {
        this.ID_Produit = ID_Produit;
    }
}
