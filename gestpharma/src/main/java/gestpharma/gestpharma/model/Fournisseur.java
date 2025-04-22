package gestpharma.gestpharma.model;

public class Fournisseur {
    private String ID_fournisseur;
    private String nom_fournisseur;

    public Fournisseur() {}
    public Fournisseur(String ID_fournisseur, String nom_fournisseur) {
        this.ID_fournisseur = ID_fournisseur;
        this.nom_fournisseur = nom_fournisseur;
    }

    //getters

    public String getID_fournisseur() {
        return ID_fournisseur;
    }
    public String getNom_fournisseur() {
        return nom_fournisseur;
    }

    //setters

    public void setID_fournisseur(String ID_fournisseur) {
        this.ID_fournisseur = ID_fournisseur;
    }
    public void setNom_fournisseur(String nom_fournisseur) {
        this.nom_fournisseur = nom_fournisseur;
    }
}
