package gestpharma.gestpharma.model;

public class Prescrit {
    private String ID_Produit;
    private String ID_prescription;
    public Prescrit(Produit produit,Prescription prescription) {
        this.ID_Produit = produit.getID_Produit();
        this.ID_prescription = produit.getID_Produit();
    }

    //getters

    public String getID_Produit() {
        return ID_Produit;
    }
    public String getID_prescription() {
        return ID_prescription;
    }

    //setters

    public void setID_Produit(String ID_Produit) {
        this.ID_Produit = ID_Produit;
    }
    public void setID_prescription(String ID_prescription) {
        this.ID_prescription = ID_prescription;
    }
}
