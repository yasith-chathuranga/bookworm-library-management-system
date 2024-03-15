package lk.ijse.bookWormLibraryManagementSystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @Column(length = 20)
    private String bId;
    private String title;
    private String author;
    private String genre;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "book")
    private List<Detail> detailList;

    public Book() {
    }

    public Book(String bId, String title, String author, String genre, String status) {
        this.setbId(bId);
        this.setTitle(title);
        this.setAuthor(author);
        this.setGenre(genre);
        this.setStatus(status);
    }

    private String status;

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
