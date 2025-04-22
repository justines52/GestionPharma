package gestpharma.gestpharma.model;

import java.time.LocalDate;

public class Patient {
    private String ID_Patient;
    private char genre_Patient;
    private LocalDate date_Naissance;
    private String nom_Patient;
    private String prenom_Patient;

    public Patient() {}
    public Patient(String ID_Patient, String nom_Patient, String prenom_Patient, char genre_Patient, LocalDate date_Naissance) {
        this.ID_Patient = ID_Patient;
        this.nom_Patient = nom_Patient;
        this.prenom_Patient = prenom_Patient ;
        this.genre_Patient = genre_Patient ;
        this.date_Naissance = date_Naissance;
    }

    //getters

    public String getID_Patient() {
        return ID_Patient;
    }
    public char getGenre_Patient() {
        return genre_Patient;
    }
    public LocalDate getDate_Naissance() {
        return date_Naissance;
    }
    public String getNom_Patient() {
        return nom_Patient;
    }
    public String getPrenom_Patient() {
        return prenom_Patient;
    }


    //setters
    public void setID_Patient(String ID_Patient) {
        this.ID_Patient = ID_Patient;
    }
    public void setGenre_Patient(char genre_Patient) {
        this.genre_Patient = genre_Patient;
    }
    public void setDate_Naissance(LocalDate date_Naissance) {
        this.date_Naissance = date_Naissance;
    }
    public void setNom_Patient(String nom_Patient) {
        this.nom_Patient = nom_Patient;
    }
    public void setPrenom_Patient(String prenom_Patient) {
        this.prenom_Patient = prenom_Patient;
    }
}
