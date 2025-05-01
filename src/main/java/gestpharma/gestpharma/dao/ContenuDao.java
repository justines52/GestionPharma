package gestpharma.gestpharma.dao;

import gestpharma.gestpharma.model.Contenu;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface ContenuDao {
    @SqlQuery("SELECT * FROM Contenu")
    @RegisterBeanMapper(Contenu.class)
    List<Contenu> getAll();

    @SqlUpdate("DELETE FROM Contenu WHERE ID_produit = :ID_produit AND ID_lot = :ID_lot")
    void delete(@Bind("ID_produit") String ID_produit, @Bind("ID_lot") String ID_lot);

    @SqlQuery("SELECT * FROM Contenu WHERE ID_produit = :ID_produit AND ID_lot = :ID_lot")
    @RegisterBeanMapper(Contenu.class)
    Contenu getById(@Bind("ID_produit") String ID_produit , @Bind("ID_lot") String ID_lot );

    @SqlUpdate("INSERT INTO Contenu (ID_produit,id_lot) VALUES (:ID_produit, :ID_lot)")
    void insert(@BindBean Contenu contenu);
    @SqlQuery("SELECT * FROM Contenu WHERE ID_produit = :ID_produit")
    @RegisterBeanMapper(Contenu.class)
    List<Contenu> findByProduit(@Bind("ID_produit") String ID_produit);

}
