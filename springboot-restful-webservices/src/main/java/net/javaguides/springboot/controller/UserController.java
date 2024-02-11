package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.exception.ErrorDetails;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController     //-- Developing Restful Web Services using Spring MVC
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    @Autowired  //-- Not essential because Constructor has only 1 parameter (userService)
    private UserService userService;


    //-- Create User REST API ------------------------------------------------------------------------------------------
/*    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }*/

    //-- Create User REST API using DTO Class
    @PostMapping("create")
    public ResponseEntity<UserDto> createUserDto(@RequestBody UserDto userDto){
        UserDto savedUser = userService.createUserDto(userDto);
        return  new ResponseEntity<>(savedUser,HttpStatus.CREATED);
    }


    //-- Get User by ID REST API ---------------------------------------------------------------------------------------
    //-- http://localhost:8080/api/users/1 (Postman)
/*    @GetMapping("{id}")
    public ResponseEntity<User> getUserByID(@PathVariable("id") Long userId){
        User user = userService.getUserByID(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }*/

    //-- Get User by ID REST API using DTO Class
    //-- http://localhost:8080/api/users/get/1 (Postman)
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserByIdDto(@PathVariable("id") Long userId){
        UserDto userDto = userService.getUserByIdDto(userId);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }


    //-- Get all users REST API ----------------------------------------------------------------------------------------
    //-- http://localhost:8080/api/users/all
/*    @GetMapping("all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }*/

    //-- Get all users REST API using DTO Class
    //-- http://localhost:8080/api/users/getall
    @GetMapping("all")
    public ResponseEntity<List<UserDto>> getAllUsersDto(){
        List<UserDto> users = userService.getAllUsersDto();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    //-- Update User ---------------------------------------------------------------------------------------------------
    //-- http://localhost:8080/api/users/update     //-- Need to send Updating information as a JSON
/*    @PutMapping("update/{id}")
    public ResponseEntity<User> updateUserByID(@RequestBody User user, @PathVariable("id") Long userID){
        user.setId(userID);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }*/

    @PutMapping("update/{id}")
    public ResponseEntity<UserDto> updateUserByID(@RequestBody UserDto user, @PathVariable("id") Long userID){
        user.setId(userID);
        UserDto updatedUser = userService.updateUserDto(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    //-- Update User Method 2
    //-- http://localhost:8080/api/users/update?userId=1&firstName=Nick&lastName=Jonas&email=nick@jonas.com
/*    @PostMapping("update")
    public ResponseEntity<User> updateUserById(@RequestParam Long userId, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email){
        User user = userService.getUserByID(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);

        User savedUser = userService.updateUser(user);

        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
    }*/


    //-- Delete User By ID ---------------------------------------------------------------------------------------------
    //-- http://localhost:8080/api/users/delete/3
    @DeleteMapping("delete/{id}")
    ResponseEntity<User> deleteUserByID(@PathVariable("id") Long id){
        User deletedUser = userService.deleteUser(id);      //-- Assign deleted user's Object taken from UserController to a variable
        return new ResponseEntity<>(deletedUser,HttpStatus.OK);     //-- Display the deleted user's info as a JSON in the web client
    }


    //-- Handle specific Exceptions related only to UserController Class
    @ExceptionHandler(ResourceNotFoundException.class)  //-- Annotation is used to handle Specific Exceptions, return custom error response.
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                                                    exception.getMessage(),
                                                    webRequest.getDescription(false),
                                                    "User_Not_Found" );

        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }

}
