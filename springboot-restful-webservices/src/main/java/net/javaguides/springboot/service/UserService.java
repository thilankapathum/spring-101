package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    UserDto createUserDto(UserDto user);

    User getUserByID(Long id);
    UserDto getUserByIdDto(Long id);

    List<User> getAllUsers();
    List<UserDto> getAllUsersDto();

    User updateUser(User user);

    User deleteUser(Long id);
}
