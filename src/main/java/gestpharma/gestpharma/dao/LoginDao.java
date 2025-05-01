package gestpharma.gestpharma.dao;

import gestpharma.gestpharma.model.Login;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
@RegisterBeanMapper(Login.class)
public interface LoginDao {

    @SqlQuery("SELECT * FROM login")
    @RegisterBeanMapper(Login.class)
    List<Login> getAll();

    @SqlUpdate("DELETE FROM login WHERE ID_login = :ID_login")
    void delete(@Bind("ID_login") int ID_login);

    @SqlQuery("SELECT * FROM login WHERE ID_login = :ID_login")
    @RegisterBeanMapper(Login.class)
    Login getById(@Bind("ID_login") int ID_login);

    @SqlUpdate("INSERT INTO login (nom_utilisateur, mot_de_passe) VALUES (:nom_utilisateur, :mot_de_passe)")
    void insert(@Bind("nom_utilisateur") String nom_utilisateur, @Bind("mot_de_passe") String mot_de_passe);


    @SqlQuery("SELECT * FROM login WHERE nom_utilisateur = :nom_utilisateur")
    @RegisterBeanMapper(Login.class)
    Login getByUsername(@Bind("nom_utilisateur") String nom_utilisateur);

}
