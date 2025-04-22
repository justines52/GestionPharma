package gestpharma.gestpharma.model;

public abstract class Produit {
    private String ID_Produit;

    public Produit() {}
    public Produit(String ID_Produit) {
        this.ID_Produit = ID_Produit;
    }

    //getters

    public String getID_Produit() {
        return ID_Produit;
    }

    //setters

    public void setID_Produit(String ID_Produit) {
        this.ID_Produit = ID_Produit;
    }

}
