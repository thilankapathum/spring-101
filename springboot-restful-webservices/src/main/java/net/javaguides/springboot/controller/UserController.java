package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController     //-- Developing Resful Web Services using Spring MVC
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    @Autowired  //-- Not essential because Constructor has only 1 parameter (userService)
    private UserService userService;

    //-- Create User REST API
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //-- Get User by ID REST API
    //-- http://localhost:8080/api/users/1 (Postman)
    @GetMapping("{id}")
    public ResponseEntity<User> getUserByID(@PathVariable("id") Long userId){
        User user = userService.getUserByID(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    //-- Get all users REST API
    //-- http://localhost:8080/api/users/all
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    //-- Update User
    //-- http://localhost:8080/api/users/update     //-- Need to send Updating information as a JSON
    @PutMapping("update/{id}")
    public ResponseEntity<User> updateUserByID(@RequestBody User user, @PathVariable("id") Long userID){
        user.setId(userID);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    //-- Update User 2
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


    //-- Delete User By ID
    //-- http://localhost:8080/api/users/delete/3
    @DeleteMapping("delete/{id}")
    ResponseEntity<User> deleteUserByID(@PathVariable("id") Long id){
        User deletedUser = userService.deleteUser(id);      //-- Assign deleted user's Object taken from UserController to a variable
        return new ResponseEntity<>(deletedUser,HttpStatus.OK);     //-- Display the deleted user's info as a JSON in the web client
    }
}
