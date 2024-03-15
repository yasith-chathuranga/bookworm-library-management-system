package lk.ijse.bookWormLibraryManagementSystem.dao.custom;

import lk.ijse.bookWormLibraryManagementSystem.entity.Book;
import org.hibernate.Session;

import java.util.List;

public interface BookDao {

    public void setSession(Session session);


    public List<Book> loadAll() ;


    public String save(Book book);


    public void update(Book book);

    public void delete(Book book);


    public Book getObject(String id) throws Exception ;


    public List<String> bookIds() ;
}
