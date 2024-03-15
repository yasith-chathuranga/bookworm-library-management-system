package lk.ijse.bookWormLibraryManagementSystem.bo.impl;

import lk.ijse.bookWormLibraryManagementSystem.bo.custom.BookBo;
import lk.ijse.bookWormLibraryManagementSystem.dao.custom.BookDao;
import lk.ijse.bookWormLibraryManagementSystem.dao.impl.BookDaoImpl;
import lk.ijse.bookWormLibraryManagementSystem.dto.BookDto;
import lk.ijse.bookWormLibraryManagementSystem.entity.Book;
import lk.ijse.bookWormLibraryManagementSystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BookBoImpl implements BookBo {

    private Session session;

    BookDao bookDao = new BookDaoImpl();


    public List<BookDto> loadAll() {
        session = SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction = session.beginTransaction ();

        bookDao.setSession (session);
        List<Book>list = bookDao.loadAll ();
        List<BookDto>bookdtoList = new ArrayList<>();

        for (Book book:list) {
            bookdtoList.add(
                    new BookDto (
                            book.getbId(),
                            book.getTitle(),
                            book.getAuthor(),
                            book.getGenre(),
                            book.getStatus()
                    )
            );
        }
        return bookdtoList;
    }

    public boolean saveBook(BookDto dto) {
        session= SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        try{
            bookDao.setSession (session);
            bookDao.save (new Book (
                    dto.getBId(),
                    dto.getTitle (),
                    dto.getAuthor (),
                    dto.getGenre (),
                    dto.getStatus()
            ));
            transaction.commit ();
            session.close ();
            return true;

        }catch (Exception e){
            transaction.rollback ();
        }
        return false;
    }

    public boolean updateBook(BookDto dto) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        try {
            bookDao.setSession (session);
            bookDao.update (new Book (
                    dto.getBId(),
                    dto.getTitle(),
                    dto.getAuthor(),
                    dto.getGenre(),
                    dto.getStatus()
            ));

            transaction.commit ();
            session.close ();
            return true;
        }catch (Exception e){
            transaction.rollback ();;
        }
        return false;
    }

    public boolean deleteBook(BookDto dto) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        try{
            bookDao.setSession (session);
            bookDao.delete (new Book (
                    dto.getBId(),
                    dto.getTitle (),
                    dto.getAuthor(),
                    dto.getGenre (),
                    dto.getStatus()
            ));
            transaction.commit ();
            session.close ();
            return true;
        }catch (Exception e){
            transaction.rollback ();
        }
        return false;
    }

    public BookDto getBook(String id) throws Exception {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction = session.beginTransaction ();
        bookDao.setSession (session);
        Book book=bookDao.getObject (id);
        session.close ();
        return new BookDto (
                book.getbId(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre(),
                book.getStatus()

        );
    }
}
