package gestpharma.gestpharma.dao;

import gestpharma.gestpharma.model.Lot;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface LotDao {
    @SqlQuery("SELECT * FROM Lot")
    @RegisterBeanMapper(Lot.class)
    List<Lot> getAll();

    @SqlUpdate("DELETE FROM Lot WHERE ID_lot = :ID_Lot")
    void delete(@Bind("ID_Lot") String ID_Lot);

    @SqlQuery("SELECT * FROM Lot WHERE ID_Lot = :ID_Lot")
    @RegisterBeanMapper(Lot.class)
    Lot getById(@Bind("ID_Lot") String ID_Lot);

    @SqlUpdate("INSERT INTO Lot (ID_Lot, date_fabrication, date_expiration,quantite) VALUES (:ID_Lot, :date_fabrication, :date_expiration, :quantite)")
    void insert(@BindBean Lot lot);
}


