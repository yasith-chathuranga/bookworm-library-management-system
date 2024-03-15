package lk.ijse.bookWormLibraryManagementSystem.dao.custom;

import lk.ijse.bookWormLibraryManagementSystem.entity.Detail;
import org.hibernate.Session;

import java.util.List;

public interface DetailDao {
    void setSession(Session session);

    List<Detail> loadAll();

    String save(Detail detail);

    void update(Detail detail);

    void delete(Detail detail);

    Detail getObject(String id) throws Exception ;
}
