package gestpharma.gestpharma.model;
import java.util.ArrayList;

public class Preparateur extends Login {
    private String ID_preparateur;
    private String nom_preparateur;
    private String prenom_preparateur;
    private ArrayList<Commande> commandes;

    public Preparateur() {};

    public Preparateur(String ID_preparateur, String nom_preparateur, String prenom_preparateur, String ID_login, String password, String nom_utilisateur) {
        super(ID_login, password, nom_utilisateur);
        this.ID_preparateur = ID_preparateur;
        this.nom_preparateur = nom_preparateur;
        this.prenom_preparateur = prenom_preparateur;
        this.commandes = new ArrayList<>();
    }

    public void addCommande(Commande commande) {
        commandes.add(commande);
    }

    //getters

    public String getID_preparateur() {
        return ID_preparateur;
    }
    public String getNom_preparateur() {
        return nom_preparateur;
    }
    public String getPrenom_preparateur() {
        return prenom_preparateur;
    }
    public ArrayList<Commande> getCommandes() {
        return commandes;
    }


    //setters

    public void setID_preparateur(String ID_preparateur) {
        this.ID_preparateur = ID_preparateur;
    }
    public void setNom_preparateur(String nom_preparateur) {
        this.nom_preparateur = nom_preparateur;
    }
    public void setPrenom_preparateur(String prenom_preparateur) {
        this.prenom_preparateur = prenom_preparateur;
    }
    public void setCommandes(ArrayList<Commande> commandes) {
        this.commandes = commandes;
    }




}
