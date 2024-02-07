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

    /*public ResponseEntity<User> updateUserById(Long userId, String firstName, String lastName, String email){
        User user = userService.getUserByID(userId);

        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }*/
}
