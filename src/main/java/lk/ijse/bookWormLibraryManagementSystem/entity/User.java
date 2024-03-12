package lk.ijse.bookWormLibraryManagementSystem.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class User {

    @Id
    @Column(name = "user_id", length = 20)
    private String userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    private List<Detail> detailList;

    public User() {
    }

    public User(String userId, String userName, String password, List<Detail> detailList) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.detailList = detailList;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDetailList(List<Detail> detailList) {
        this.detailList = detailList;
    }
}
