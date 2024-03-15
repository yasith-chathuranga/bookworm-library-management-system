package lk.ijse.bookWormLibraryManagementSystem.bo.custom;

import lk.ijse.bookWormLibraryManagementSystem.dto.BookDto;
import lk.ijse.bookWormLibraryManagementSystem.dto.DetailDto;
import lk.ijse.bookWormLibraryManagementSystem.dto.UserDto;

import java.util.List;

public interface DetailBo {

    public List<String> getUserIds() ;

    public List<String> getBookIds() ;

    public UserDto getUser(String id) ;

    public BookDto getBook(String id) ;

    public DetailDto getDetail(String detailId);

    public boolean updateBook(BookDto dto) ;

    public List<DetailDto> loadAllDetail();

    public boolean saveDetail(DetailDto det);

    public boolean updateDetail(DetailDto det);

    public boolean deleteDetail(DetailDto det) ;

    public List<DetailDto> loadAll();
}
