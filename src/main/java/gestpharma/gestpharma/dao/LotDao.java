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

    @SqlUpdate("DELETE FROM Lot WHERE ID_lot = :ID_lot")
    void delete(@Bind("ID_lot") String ID_lot);

    @SqlQuery("SELECT * FROM Lot WHERE ID_lot = :ID_lot")
    @RegisterBeanMapper(Lot.class)
    Lot getById(@Bind("ID_lot") String ID_lot);

    @SqlUpdate("INSERT INTO Lot (ID_lot, date_fabrication, date_expiration,quantite) VALUES (:ID_lot, :date_fabrication, :date_expiration, :quantite)")
    void insert(@BindBean Lot lot);

    @SqlUpdate("""
    UPDATE Lot 
    SET date_fabrication = :date_fabrication, 
        date_expiration = :date_expiration, 
        quantite = :quantite 
    WHERE ID_lot = :ID_lot
""")
    void update(@BindBean Lot lot);

}


