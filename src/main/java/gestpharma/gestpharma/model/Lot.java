package gestpharma.gestpharma.model;

import java.time.LocalDate;

public class Lot {
    private String ID_lot;
    private int quantite;
    private LocalDate date_fabrication;
    private LocalDate date_expiration;

    public Lot() {}
    public Lot(String ID_lot , int quantite, LocalDate date_fabrication, LocalDate date_expiration) {
        this.ID_lot = ID_lot;
        this.quantite = quantite;
        this.date_fabrication = date_fabrication;
        this.date_expiration = date_expiration;
    }


    //getters

    public String getID_lot() {return ID_lot;}
    public int getQuantite() {return quantite;}
    public LocalDate getDate_fabrication() {return date_fabrication;}
    public LocalDate getDate_expiration() {return date_expiration;}

    //setters
    public void setID_lot(String ID_lot) {this.ID_lot = ID_lot;}
    public void setQuantite(int quantite) {this.quantite = quantite;}
    public void setDate_fabrication(LocalDate date_fabrication) {this.date_fabrication = date_fabrication;}
    public void setDate_expiration(LocalDate date_expiration) {this.date_expiration = date_expiration;}
}
