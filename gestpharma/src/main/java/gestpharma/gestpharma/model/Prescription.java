package gestpharma.gestpharma.model;


public class Prescription {
    private String ID_Prescription;
    private String ID_Patient;
    private String ID_Medecin;
    private int quantite;
    private String posologie;
    private String mode_Administration;
    private int numero_Billet_Salle;

    public Prescription() {}
    public Prescription(String ID_Prescription, String ID_Patient, String ID_Medecin,
                        int quantite, String posologie, String mode_Administration, int numero_Billet_Salle) {
        this.ID_Prescription = ID_Prescription;
        this.ID_Patient = ID_Patient;
        this.ID_Medecin = ID_Medecin;
        this.quantite = quantite;
        this.posologie = posologie;
        this.mode_Administration = mode_Administration;
        this.numero_Billet_Salle = numero_Billet_Salle;
    }

    //getters
    public String getID_Prescription() {
        return ID_Prescription;
    }
    public String getID_Patient() {
        return ID_Patient;
    }
    public String getID_Medecin() {
        return ID_Medecin;
    }
    public int getQuantite() {
        return quantite;
    }
    public String getPosologie() {
        return posologie;
    }
    public String getMode_Administration() {
        return mode_Administration;
    }
    public int getNumero_Billet_Salle() {
        return numero_Billet_Salle;
    }

    //setters

    public void setID_Prescription(String ID_Prescription) {
        this.ID_Prescription = ID_Prescription;
    }
    public void setID_Patient(String ID_Patient) {
        this.ID_Patient = ID_Patient;
    }
    public void setID_Medecin(String ID_Medecin) {
        this.ID_Medecin = ID_Medecin;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public void setPosologie(String posologie) {
        this.posologie = posologie;
    }
    public void setMode_Administration(String mode_Administration) {
        this.mode_Administration = mode_Administration;
    }
    public void setNumero_Billet_Salle(int numero_Billet_Salle) {
        this.numero_Billet_Salle = numero_Billet_Salle;
    }


}
