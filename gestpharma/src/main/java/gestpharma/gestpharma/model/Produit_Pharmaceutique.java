package gestpharma.gestpharma.model;
public class Produit_Pharmaceutique extends Produit {
    private String ID_Produit_Pharmaceutique;
    private String Type_Parapharmaceutique;
    private String DosageQuantiteDeMolecule;
    private String Forme;
    private String Voie_Administration;

    public Produit_Pharmaceutique(String ID_produit, String ID_Produit_Pharmaceutique,
                                  String Type_Parapharmaceutique, String DosageQuantiteDeMolecule,
                                  String Forme, String Voie_Administration) {
        super(ID_produit);
        this.ID_Produit_Pharmaceutique = ID_Produit_Pharmaceutique;
        this.Type_Parapharmaceutique = Type_Parapharmaceutique;
        this.DosageQuantiteDeMolecule = DosageQuantiteDeMolecule;
        this.Forme = Forme;
        this.Voie_Administration = Voie_Administration;
    }

    // Getters and Setters
    public String getID_Produit_Pharmaceutique() {
        return ID_Produit_Pharmaceutique;
    }

    public void setID_Produit_Pharmaceutique(String ID_Produit_Pharmaceutique) {
        this.ID_Produit_Pharmaceutique = ID_Produit_Pharmaceutique;
    }

    public String getType_Parapharmaceutique() {
        return Type_Parapharmaceutique;
    }

    public void setType_Parapharmaceutique(String Type_Parapharmaceutique) {
        this.Type_Parapharmaceutique = Type_Parapharmaceutique;
    }

    public String getDosageQuantiteDeMolecule() {
        return DosageQuantiteDeMolecule;
    }

    public void setDosageQuantiteDeMolecule(String DosageQuantiteDeMolecule) {
        this.DosageQuantiteDeMolecule = DosageQuantiteDeMolecule;
    }

    public String getForme() {
        return Forme;
    }

    public void setForme(String Forme) {
        this.Forme = Forme;
    }

    public String getVoie_Administration() {
        return Voie_Administration;
    }

    public void setVoie_Administration(String Voie_Administration) {
        this.Voie_Administration = Voie_Administration;
    }
}