package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.exception.EmailAlreadyExistsException;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.mapper.UserMapper;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service    //-- Service Class
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired  //-- Not essential (Because this class has only Single-Parameterized Constructor)
    private UserRepository userRepository;
    private ModelMapper modelMapper;


/*    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }*/

    @Override
    public UserDto createUserDto(UserDto userDto) {

        //-- Checking whether the user input email address already exists
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email already exists!");
        }

        //-- Convert UserDto into User JPA Entity
        //User user = new User(userDto.getId(),userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
        //User user = UserMapper.mapToUser(userDto);      //-- Using UserMapper Class to reduce code.
        User user = modelMapper.map(userDto,User.class);    //-- Using ModelMapper Class to reduce code.

        User savedUser = userRepository.save(user);

        //-- Convert User JPA Entity to UserDto
        //UserDto savedUserDto = new UserDto(savedUser.getId(), savedUser.getFirstName(), savedUser.getLastName(), savedUser.getEmail());
        //UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);      //-- Using UserMapper Class to reduce code.
        UserDto savedUserDto = modelMapper.map(savedUser,UserDto.class);    //-- Using ModelMapper Class to reduce code.

        return savedUserDto;
    }


/*    @Override
    public User getUserByID(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.get();
    }*/

    @Override
    public UserDto getUserByIdDto(Long userId){
        //Optional<User> optionalUser = userRepository.findById(userId);
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User","id",userId)     //-- returns ResourceNotFoundException Object with resourceName:User, fieldName:id, fieldValue:userId
        );
        //User user = optionalUser.get();
        //return UserMapper.mapToUserDto(user);
        return modelMapper.map(user, UserDto.class);
    }


/*    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }*/

    @Override
    public List<UserDto> getAllUsersDto() {

        List<User> users = userRepository.findAll();

        //return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
        return users.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList()); //-- Using Model Mapper
    }


/*    @Override
    public User updateUser(User user) {

        User existingUser = userRepository.findById(user.getId()).get();

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        return userRepository.save(existingUser);
    }*/

    @Override
    public UserDto updateUserDto(UserDto user) {

        //User existingUser = userRepository.findById(user.getId()).get();
        User existingUser = userRepository.findById(user.getId()).orElseThrow(      //-- Throw exception if user did not find
                () -> new ResourceNotFoundException("User","id",user.getId())
        );

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        User updatedUser = userRepository.save(existingUser);

        //return UserMapper.mapToUserDto(updatedUser);
        return modelMapper.map(updatedUser, UserDto.class); //-- Using Model Mapper
    }


    @Override
    public User deleteUser(Long id) {
        //User deletingUser = userRepository.findById(id).get();  //-- Hold an Object of the User just to display the deleted information
        User deletingUser = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User","id",id)
        );
        userRepository.deleteById(id);
        return deletingUser;    //-- Return UserObject to REST API to display deleted user's information
    }

/*    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }*/


}
