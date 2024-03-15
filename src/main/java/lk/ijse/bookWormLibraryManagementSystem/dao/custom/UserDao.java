package lk.ijse.bookWormLibraryManagementSystem.dao.custom;

import lk.ijse.bookWormLibraryManagementSystem.entity.User;
import org.hibernate.Session;

import java.util.List;

public interface UserDao {

    public void setSession(Session session);

    public List<User> loadAll() ;

    public String save(User user);

    public void update(User user);

    public void delete(User user) ;

    public User getObject(String id) throws Exception;

    public List<String> UserIds();
}
