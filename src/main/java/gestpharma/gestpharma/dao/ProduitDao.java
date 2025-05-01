package gestpharma.gestpharma.dao;

import gestpharma.gestpharma.model.Produit;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface ProduitDao {

    @SqlQuery("SELECT * FROM Produit")
    @RegisterBeanMapper(Produit.class)
    List<Produit> getAll();

    @SqlQuery("SELECT * FROM Produit WHERE ID_produit = :ID_produit")
    @RegisterBeanMapper(Produit.class)
    Produit getById(@Bind("ID_produit") String ID_produit);

    @SqlUpdate("INSERT INTO Produit (ID_produit,prix_unitaire) VALUES (:ID_produit,:prix_unitaire)")
    @GetGeneratedKeys
    int insert(@BindBean Produit produit);

    @SqlUpdate("UPDATE Produit SET prix_unitaire = :prix_unitaire WHERE ID_produit = :ID_produit")
    void update(@BindBean Produit produit);

    @SqlUpdate("DELETE FROM Produit WHERE ID_produit = :ID_produit")
    void delete(@Bind("ID_produit") String ID_produit);

    @SqlQuery("SELECT p.* FROM Produit p JOIN Commande c ON p.ID_produit = c.ID_produit WHERE c.ID_commande = :ID_commande")
    @RegisterBeanMapper(Produit.class)
    Produit getProduitFromCommande(@Bind("ID_commande") String ID_commande);
}
