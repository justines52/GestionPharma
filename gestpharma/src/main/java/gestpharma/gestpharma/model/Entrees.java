package gestpharma.gestpharma.model;

import java.time.LocalDate;

public class Entrees {
    private LogType type;
    private int numero_Billet_Salle;
    private String ID_facture;
    private String ID_Produit;
    private String posologie;
    private int quantite;
    private LocalDate date_expiration;
    private int prix;

    public Entrees() {}
    public Entrees ( LogType type , int numero_Billet_Salle , String ID_facture , String ID_Produit , String posologie, int quantite, LocalDate date_expiration, int prix ) {
        this.type = type;
        this.numero_Billet_Salle = numero_Billet_Salle;
        this.ID_facture = ID_facture;
        this.ID_Produit = ID_Produit;
        this.posologie = posologie;
        this.quantite = quantite;
        this.date_expiration = date_expiration;
        this.prix = prix;
    }

    //getters

    public LogType getType() { return type; }
    public int getNumero_Billet_Salle() { return numero_Billet_Salle; }
    public String getID_facture() { return ID_facture; }
    public String getID_Produit() { return ID_Produit; }
    public String getPosologie() { return posologie; }
    public int getQuantite() { return quantite; }
    public LocalDate getDate_expiration() { return date_expiration; }
    public int getPrix() { return prix; }

    //setters

    public void setType(LogType type) { this.type = type;}
    public void  setNumero_Billet_Salle (int numero_Billet_Salle) { this.numero_Billet_Salle = numero_Billet_Salle; }
    public void setID_facture (String ID_facture) { this.ID_facture = ID_facture; }
    public void setID_Produit(String ID_Produit) { this.ID_Produit = ID_Produit; }
    public void setPosologie(String posologie) { this.posologie = posologie; }
    public void setQuantite(int quantite) { this.quantite = quantite; }
    public void setDate_expiration(LocalDate date_expiration) { this.date_expiration = date_expiration; }
    public void setPrix(int prix) { this.prix = prix; }
}
