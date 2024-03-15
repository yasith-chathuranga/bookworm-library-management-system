package lk.ijse.bookWormLibraryManagementSystem.bo.impl;

import lk.ijse.bookWormLibraryManagementSystem.bo.custom.BranchesBo;
import lk.ijse.bookWormLibraryManagementSystem.dao.custom.BranchesDao;
import lk.ijse.bookWormLibraryManagementSystem.dao.impl.BranchesDaoImpl;
import lk.ijse.bookWormLibraryManagementSystem.dto.BranchesDto;
import lk.ijse.bookWormLibraryManagementSystem.entity.Branches;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BranchesBOImpl implements BranchesBo {

    BranchesDao branchesDao = new BranchesDaoImpl();

    @Override
    public boolean saveBranches(BranchesDto dto) {
        return branchesDao.save(new Branches(
                dto.getBrId(),
                dto.getBname(),
                dto.getLocation(),
                dto.getBstatus()

        ));
    }

    @Override
    public boolean updateBranches(BranchesDto dto) {
        return branchesDao.update(new Branches(
                dto.getBrId(),
                dto.getBname(),
                dto.getLocation(),
                dto.getBstatus()

        ));
    }

    @Override
    public boolean deleteBranch(Branches dto) {
        return branchesDao.delete(new Branches(
                dto.getBrId(),
                dto.getBname(),
                dto.getLocation(),
                dto.getBstatus()


        ));
    }

    @Override
    public BranchesDto searchBranch(String id) {
         Branches dto  = branchesDao.search(id);

        return new BranchesDto(
                dto.getBrId(),
                dto.getBname(),
                dto.getLocation(),
                dto.getBstatus()

        );
    }

    @Override
    public ArrayList<BranchesDto> getAllBranches() {
        ArrayList<BranchesDto> brList = new ArrayList<>();

        brList.addAll(branchesDao.getAll().stream().map(br -> {
            return new BranchesDto(
                    br.getBrId(),
                    br.getBname(),
                    br.getLocation(),
                    br.getBstatus()
            );
        }).collect(Collectors.toList()));

        return brList;
    }




}
