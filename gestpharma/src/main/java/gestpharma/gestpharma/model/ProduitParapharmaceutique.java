package gestpharma.gestpharma.model;

public class ProduitParapharmaceutique extends Produit {
    private String ID_Produit_Parapharmaceutique;
    private String Designation_Produit_Parapharmaceutique;

    public ProduitParapharmaceutique(String ID_produit, String ID_Produit_Parapharmaceutique, String Designation_Produit_Parapharmaceutique) {
        super(ID_produit);
        this.ID_Produit_Parapharmaceutique = ID_Produit_Parapharmaceutique;
        this.Designation_Produit_Parapharmaceutique = Designation_Produit_Parapharmaceutique;
    }

    //getters
    public String getID_Produit_Parapharmaceutique() {
        return ID_Produit_Parapharmaceutique;
    }
    public String getDesignation_Produit_Parapharmaceutique() {
        return Designation_Produit_Parapharmaceutique;
    }

    //setters
    public void setID_Produit_Parapharmaceutique(String ID_Produit_Parapharmaceutique) {
        this.ID_Produit_Parapharmaceutique = ID_Produit_Parapharmaceutique;
    }
    public void setDesignation_Produit_Parapharmaceutique(String Designation_Produit_Parapharmaceutique) {
        this.Designation_Produit_Parapharmaceutique = Designation_Produit_Parapharmaceutique;
    }
}