package lk.ijse.bookWormLibraryManagementSystem.dao.impl;

import lk.ijse.bookWormLibraryManagementSystem.dao.custom.BranchesDao;
import lk.ijse.bookWormLibraryManagementSystem.entity.Branches;
import lk.ijse.bookWormLibraryManagementSystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BranchesDaoImpl implements BranchesDao {
    @Override
    public boolean save(Branches entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(Branches entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(Branches entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public Branches search(String id) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Branches branches = session.get(Branches.class, id);

        transaction.commit();
        session.close();

        return branches;
    }

    @Override
    public List<Branches> getAll() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Branches> allBranches = session.createQuery("from Branches ").list();

        transaction.commit();
        session.close();

        return allBranches;
    }



    @Override
    public String findNextBranchId() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("select brId from Branches order by brId desc");

        String nextId = "BR-0001";

        if(query.list().size() == 0){
            return nextId;
        }else{
            String id = (String)query.list().get(0);

            String[] SUs = id.split("BR-");

            for (String a:SUs) {
                id = a;
            }

            int idNum = Integer.valueOf(id);

            id = "BR-" + (idNum+1);

            transaction.commit();
            session.close();

            return id;
        }

    }
}
