package lk.ijse.bookWormLibraryManagementSystem.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Book {

    @Id
    @Column(length = 20)
    private String bId;
    private String title;
    private String author;
    private String genre;
    private String status;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "book")
    private List<Detail> detailList;

    public Book() {
    }

    public Book(String bId, String title, String author, String genre, String status, List<Detail> detailList) {
        this.bId = bId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.detailList = detailList;
        this.status = status;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setDetailList(List<Detail> detailList) {
        this.detailList = detailList;
    }
}
