package lk.ijse.bookWormLibraryManagementSystem.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailTm {
   private String dId;
   private String sdate;
   private String edate;
   private String userId;
   private String pw;
   private String bookId;
   private String title;
}
