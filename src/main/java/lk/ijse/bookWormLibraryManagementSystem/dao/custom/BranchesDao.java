package lk.ijse.bookWormLibraryManagementSystem.dao.custom;

import lk.ijse.bookWormLibraryManagementSystem.entity.Branches;

import java.util.List;

public interface BranchesDao {

    public boolean save(Branches entity) ;

    public boolean update(Branches entity) ;

    public boolean delete(Branches entity) ;

    public Branches search(String id) ;

    public List<Branches> getAll() ;

    public String findNextBranchId() ;
}
