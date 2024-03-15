package lk.ijse.bookWormLibraryManagementSystem.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "branches")
public class Branches {
    @Id
    private String brId;
    private String bname;

    private String location;

    public Branches() {
    }

    public Branches(String brId, String bname, String location, String bstatus) {
        this.setBrId(brId);
        this.setBname(bname);
        this.setLocation(location);
        this.setBstatus(bstatus);
    }

    private String bstatus;

    public String getBrId() {
        return brId;
    }

    public void setBrId(String brId) {
        this.brId = brId;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBstatus() {
        return bstatus;
    }

    public void setBstatus(String bstatus) {
        this.bstatus = bstatus;
    }
}
