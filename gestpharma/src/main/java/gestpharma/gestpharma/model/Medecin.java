package gestpharma.gestpharma.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Medecin {
    private String ID_Medecin;
    private String Nom_Medecin;
    private String Prenom_Medecin;
    private String specialite;
    private ArrayList<Prescription> prescriptions;

    public Medecin() {}
    public Medecin(String Nom_Medecin, String Prenom_Medecin,String ID_Medecin, String specialite) {
        this.ID_Medecin = ID_Medecin;
        this.specialite = specialite;
        this.Nom_Medecin = Nom_Medecin;
        this.Prenom_Medecin = Prenom_Medecin;
        this.prescriptions = new ArrayList<>();
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public void removePrescription(Prescription prescription) {
        prescriptions.remove(prescription);
    }

    //getters
    public String getID_Medecin() {
        return ID_Medecin;
    }
    public String getNom_Medecin() { return Nom_Medecin;}
    public String getPrenom_Medecin() { return Prenom_Medecin;}
    public String getSpecialite() {
        return specialite;
    }
    public ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }

    //setters
    public void setID_Medecin(String ID_Medecin) {
        this.ID_Medecin = ID_Medecin;
    }
    public void setNom_Medecin(String Nom_Medecin) { this.Nom_Medecin = Nom_Medecin;}
    public void setPrenom_Medecin(String prenom_Medecin) {Prenom_Medecin = prenom_Medecin;}
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    public void setPrescriptions(ArrayList<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

}
