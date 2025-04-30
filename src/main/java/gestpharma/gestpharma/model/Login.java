package gestpharma.gestpharma.model;

public class Login {
    private int ID_login;
    private String mot_de_passe;
    private String nom_utilisateur;

    public Login() {};
    public Login(int ID_login, String mot_de_passe, String nom_utilisateur) {
        this.ID_login = ID_login;
        this.mot_de_passe = mot_de_passe;
        this.nom_utilisateur = nom_utilisateur;
    }

    // getters

    public int getID_login() {return ID_login;}
    public String getMot_de_passe() {return mot_de_passe;}
    public String getNom_utilisateur() {return nom_utilisateur;}

    //setters

    public void setID_login(int ID_login) {this.ID_login = ID_login;}
    public void setMot_de_passe(String mot_de_passe) {this.mot_de_passe = mot_de_passe;}
    public void setNom_utilisateur(String nom_utilisateur) {this.nom_utilisateur = nom_utilisateur;}
}
