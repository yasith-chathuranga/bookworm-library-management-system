package lk.ijse.bookWormLibraryManagementSystem.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "branches")
public class Branches {
    @Id
    private String brId;
    private String bName;
    private String location;
    private String status;

    public Branches() {
    }

    public Branches(String brId, String bName, String location, String status) {
        this.brId = brId;
        this.bName = bName;
        this.location = location;
        this.status = status;
    }

    public void setBrId(String brId) {
        this.brId = brId;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
