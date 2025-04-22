package gestpharma.gestpharma.model;

public class Login {
    private String ID_login;
    private String password;
    private String nom_utilisateur;

    public Login() {};
    public Login(String ID_login, String password, String Nom_utilisateur) {
        this.ID_login = ID_login;
        this.password = password;
        this.nom_utilisateur = Nom_utilisateur;
    }

    // getters

    public String getID_login() {
        return ID_login;
    }
    public String getPassword() {
        return password;
    }
    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    //setters

    public void setID_login(String ID_login) {
        this.ID_login = ID_login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setNom_utilisateur(String Nom_utilisateur) {
        this.nom_utilisateur = Nom_utilisateur;
    }
}
