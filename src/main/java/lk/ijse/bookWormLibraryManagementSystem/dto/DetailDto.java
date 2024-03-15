package lk.ijse.bookWormLibraryManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailDto {
    private String dId;
    private Date sdate;
    private Date edate;
    private UserDto user;
    private BookDto book;

}
