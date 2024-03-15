package lk.ijse.bookWormLibraryManagementSystem.bo.custom;

import lk.ijse.bookWormLibraryManagementSystem.dto.UserDto;

import java.util.List;

public interface UserBo {
    boolean saveUser(UserDto dto);
    UserDto getUser(String id) throws Exception;
    boolean updateUser(UserDto dto);
    List<UserDto> loadAll();
}
