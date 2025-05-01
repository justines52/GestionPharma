package gestpharma.gestpharma.dao;

import gestpharma.gestpharma.model.Commande;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.time.LocalDate;
import java.util.List;

public interface CommandeDao {
    @SqlQuery("SELECT * FROM Commande")
    @RegisterBeanMapper(Commande.class)
    List<Commande> getAll();

    @SqlUpdate("DELETE FROM Commande WHERE ID_commande = :ID_commande")
    void delete(@Bind("ID_commande") String ID_commande);

    @SqlQuery("SELECT * FROM Commande WHERE ID_commande = :ID_commande")
    @RegisterBeanMapper(Commande.class)
    Commande getById(@Bind("ID_commande") String ID_commande);

    @SqlUpdate("INSERT INTO Commande (ID_commande, date_commande, ID_produit, ID_preparateur) " +
            "VALUES (:ID_commande, :date_commande, :ID_produit, :ID_preparateur)")
    void insert(
            @Bind("ID_commande") String ID_commande,
            @Bind("date_commande") LocalDate date_commande,
            @Bind("ID_produit") String ID_produit,
            @Bind("ID_preparateur") int ID_preparateur
    );

    @SqlQuery("SELECT ID_produit FROM Commande WHERE ID_commande = :ID_commande")
    String getProduitIdByCommande(@Bind("ID_commande") String ID_commande);

    @SqlQuery("SELECT * FROM Commande WHERE ID_produit = :ID_produit")
    @RegisterBeanMapper(Commande.class)
    List<Commande> findByProduit(@Bind("ID_produit") String ID_produit);
}
