package lk.ijse.bookWormLibraryManagementSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Detail {
  @Id
  private  String dId;
  private Date sDate;
  private Date eDate;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public Detail(String dId, Date sDate, Date eDate, User user, Book book) {
    this.setdId(dId);
    this.setsDate(sDate);
    this.seteDate(eDate);
    this.setUser(user);
    this.setBook(book);
  }

  @ManyToOne
  @JoinColumn(name = "bId")
  private Book book;

  public Detail() {
  }

  public String getdId() {
    return dId;
  }

  public void setdId(String dId) {
    this.dId = dId;
  }

  public Date getsDate() {
    return sDate;
  }

  public void setsDate(Date sDate) {
    this.sDate = sDate;
  }

  public Date geteDate() {
    return eDate;
  }

  public void seteDate(Date eDate) {
    this.eDate = eDate;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }
}
