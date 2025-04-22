package gestpharma.gestpharma.model;

public class ProduitLaboratoire extends Produit {
    private String ID_Produit_Laboratoire;
    private String Designation_Produit_Laboratoire;

    public ProduitLaboratoire() {}
    public ProduitLaboratoire(String ID_produit, String ID_Produit_Laboratoire,
                               String Designation_Produit_Laboratoire) {
        super(ID_produit);
        this.ID_Produit_Laboratoire = ID_Produit_Laboratoire;
        this.Designation_Produit_Laboratoire = Designation_Produit_Laboratoire;
    }

    //getters
    public String getID_Produit_Laboratoire() {
        return ID_Produit_Laboratoire;
    }
    public String getDesignation_Produit_Laboratoire() {
        return Designation_Produit_Laboratoire;
    }

    //setters
    public void setID_Produit_Laboratoire(String ID_Produit_Laboratoire) {
        this.ID_Produit_Laboratoire = ID_Produit_Laboratoire;
    }
    public void setDesignation_Produit_Laboratoire(String Designation_Produit_Laboratoire) {
        this.Designation_Produit_Laboratoire = Designation_Produit_Laboratoire;
    }
}