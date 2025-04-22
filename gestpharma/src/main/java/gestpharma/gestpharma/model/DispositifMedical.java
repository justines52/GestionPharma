package gestpharma.gestpharma.model;

public class DispositifMedical extends Produit {
    private String ID_Dispositif_Medical;
    private String Designation_Dispositif_Medical;

    public DispositifMedical() {}
    public DispositifMedical(String ID_produit, String ID_Dispositif_Medical,String Designation_Dispositif_Medical) {
        super(ID_produit);
        this.ID_Dispositif_Medical = ID_Dispositif_Medical;
        this.Designation_Dispositif_Medical = Designation_Dispositif_Medical;
    }

    //getters

    public String getID_Dispositif_Medical() {
        return ID_Dispositif_Medical;
    }
    public String getDesignation_Dispositif_Medical() {
        return Designation_Dispositif_Medical;
    }

    //setters

    public void setID_Dispositif_Medical(String ID_Dispositif_Medical) {
        this.ID_Dispositif_Medical = ID_Dispositif_Medical;
    }
    public void setDesignation_Dispositif_Medical(String Designation_Dispositif_Medical) {
        this.Designation_Dispositif_Medical = Designation_Dispositif_Medical;
    }
}
