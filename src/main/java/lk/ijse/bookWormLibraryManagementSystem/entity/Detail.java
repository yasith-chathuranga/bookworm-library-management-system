package lk.ijse.bookWormLibraryManagementSystem.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Entity
public class Detail {
    @Id
    private  String dId;
    private Date sDate;
    private Date eDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bId")
    private Book book;

    public Detail() {
    }

    public Detail(String dId, Date sDate, Date eDate, User user, Book book) {
        this.dId = dId;
        this.sDate = sDate;
        this.eDate = eDate;
        this.user = user;
        this.book = book;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
