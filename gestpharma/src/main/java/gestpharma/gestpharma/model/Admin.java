package gestpharma.gestpharma.model;

public class Admin extends Login{
    private String ID_admin;
    private String nom_admin;
    private String prenom_admin;

    public Admin() {}

    public Admin(String ID_admin, String nom_admin, String prenom_admin, String password, String nom_utilisateur,String ID_login) {
        super(ID_login, password, nom_utilisateur);
        this.ID_admin = ID_admin;
        this.nom_admin = nom_admin;
        this.prenom_admin = prenom_admin;
    }
}
