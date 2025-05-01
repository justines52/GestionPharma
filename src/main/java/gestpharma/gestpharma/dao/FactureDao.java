package gestpharma.gestpharma.dao;

import gestpharma.gestpharma.model.Facture;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface FactureDao {
    @SqlQuery("SELECT * FROM Facture")
    @RegisterBeanMapper(Facture.class)
    List<Facture> getAll();

    @SqlUpdate("DELETE FROM Facture WHERE ID_facture = :ID_facture")
    void delete(@Bind("ID_facture") String ID_facture);

    @SqlQuery("SELECT * FROM Facture WHERE ID_facture = :ID_facture")
    @RegisterBeanMapper(Facture.class)
    Facture getById(@Bind("ID_facture") String ID_facture);


    @SqlUpdate("INSERT INTO Facture (ID_facture, date_facture,ID_fournisseur) VALUES (:ID_facture, :date_facture,:ID_fournisseur)")
    void insert(@BindBean Facture facture);

}
