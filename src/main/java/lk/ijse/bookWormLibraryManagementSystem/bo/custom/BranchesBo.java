package lk.ijse.bookWormLibraryManagementSystem.bo.custom;

import lk.ijse.bookWormLibraryManagementSystem.dto.BranchesDto;
import lk.ijse.bookWormLibraryManagementSystem.entity.Branches;

import java.util.ArrayList;

public interface BranchesBo {

    boolean saveBranches(BranchesDto dto) ;

    boolean updateBranches(BranchesDto dto);

    boolean deleteBranch(Branches dto) ;

    BranchesDto searchBranch(String id);

    ArrayList<BranchesDto> getAllBranches();
}
