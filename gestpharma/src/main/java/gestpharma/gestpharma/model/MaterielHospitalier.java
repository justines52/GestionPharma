package gestpharma.gestpharma.model;

public class MaterielHospitalier extends Produit {
    private String ID_Materiel_Hospitalier;
    private String Designation_Materiel_Hospitalier;

    public MaterielHospitalier(String ID_produit, String ID_Materiel_Hospitalier,String Designation_Materiel_Hospitalier) {
        super(ID_produit);
        this.ID_Materiel_Hospitalier = ID_Materiel_Hospitalier;
        this.Designation_Materiel_Hospitalier = Designation_Materiel_Hospitalier;
    }

    //getters

    public String getID_Materiel_Hospitalier() {
        return ID_Materiel_Hospitalier;
    }
    public String getDesignation_Materiel_Hospitalier() {
        return Designation_Materiel_Hospitalier;
    }

    //setters

    public void setID_Materiel_Hospitalier(String ID_Materiel_Hospitalier) {
        this.ID_Materiel_Hospitalier = ID_Materiel_Hospitalier;
    }

    public void setDesignation_Materiel_Hospitalier(String designation_Materiel_Hospitalier) {
        Designation_Materiel_Hospitalier = designation_Materiel_Hospitalier;
    }
}
