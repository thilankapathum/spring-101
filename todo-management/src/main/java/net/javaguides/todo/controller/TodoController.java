package net.javaguides.todo.controller;

import lombok.AllArgsConstructor;
import net.javaguides.todo.dto.TodoDto;
import net.javaguides.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")     //-- Define base url
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    //-- Add Todo REST API
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")   //-- Method Level Security
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){

        TodoDto savedTodo = todoService.addTodo(todoDto);

        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }


    //-- Get Todo by ID REST API
    @GetMapping("{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")      //-- Method Level Security for multiple Roles
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId){

        TodoDto todoDto = todoService.getTodo(todoId);

        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }


    //-- Get All Todos REST API
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos(){

        List<TodoDto> todoDtos = todoService.getAllTodo();

        //return new ResponseEntity<>(todoDtos,HttpStatus.OK);
        return ResponseEntity.ok(todoDtos);
    }


    //-- Update Todo REST API
    @PutMapping("{id}")     //-- PutMapping updates whole Object
    @PreAuthorize("hasRole('ADMIN')")   //-- Method Level Authorization
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long todoId){
        TodoDto updatedTodoDto = todoService.updateTodo(todoDto,todoId);

        return ResponseEntity.ok(updatedTodoDto);
    }


    //-- Delete Todo REST API
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")   //-- Method Level Authorization
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
        todoService.deleteTodo(todoId);

        return ResponseEntity.ok("Deleted successfully");
    }


    //-- Complete-Todo REST API
    @PatchMapping("{id}/complete")       //-- PatchMapping updates some fields in the Object only
    @PreAuthorize("hasAnyRole('ADMIN','USER')")      //-- Method Level Security for multiple Roles
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId){
        TodoDto todoDto = todoService.completeTodo(todoId);

        return ResponseEntity.ok(todoDto);
    }


    //-- In-Complete-Todo REST API
    @PatchMapping("{id}/incomplete")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")      //-- Method Level Security for multiple Roles
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id") Long todoId){
        TodoDto todoDto = todoService.inCompleteTodo(todoId);

        return ResponseEntity.ok(todoDto);
    }

}
