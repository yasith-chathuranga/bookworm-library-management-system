package lk.ijse.bookWormLibraryManagementSystem.dao.impl;

import lk.ijse.bookWormLibraryManagementSystem.dao.custom.DetailDao;
import lk.ijse.bookWormLibraryManagementSystem.entity.Detail;
import lk.ijse.bookWormLibraryManagementSystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DetailDaoImpl implements DetailDao {
    private Session session;
    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public List<Detail> loadAll() {
        String sqlQuery="FROM Detail ";
        Query query = session.createQuery(sqlQuery);
        List list =query.list ();
        session.close();
        return list;
    }

    @Override
    public String save(Detail detail) {
        return (String) session.save(detail);
    }

    @Override
    public void update(Detail detail) {
        session.update(detail);
    }

    @Override
    public void delete(Detail detail) {
        session.delete(detail);
    }

    @Override
    public Detail getObject(String id) throws Exception {
        return session.get(Detail.class,id);
    }
    public List<Detail> getAllNotReturn() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Detail> allNotReturn = session.createQuery("select dId from Detail where  id like: ID").setParameter("ID", "NOT RETURN").list();

        transaction.commit();
        session.close();

        return allNotReturn;
    }
}
