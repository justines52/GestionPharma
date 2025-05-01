package gestpharma.gestpharma.model;

public class Contenu {
    private String ID_Lot;
    private String ID_Produit;
    private Lot lot;

    public Contenu() {}
    public Contenu(Lot lot, Produit produit) {
        this.ID_Lot = lot.getID_lot();
        this.ID_Produit = produit.getID_produit();
    }

    //getters

    public String getID_Lot() {return ID_Lot;}
    public String getID_Produit() {return ID_Produit;}
    public Lot getLot() {return lot;}

    //setters
    public void setID_Lot(String ID_Lot) {this.ID_Lot = ID_Lot;}
    public void setID_Produit(String ID_Produit) {this.ID_Produit = ID_Produit;}
    public void setLot(Lot lot) {this.lot = lot;}
}
