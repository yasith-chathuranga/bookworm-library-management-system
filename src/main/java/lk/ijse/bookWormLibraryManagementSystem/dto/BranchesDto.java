package lk.ijse.bookWormLibraryManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchesDto {
    private String brId;
    private String bname;
    private String location;
    private String bstatus;

}
