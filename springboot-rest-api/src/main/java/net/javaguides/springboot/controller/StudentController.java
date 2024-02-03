package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("students")       //-- this will define base URL as http://localhost:8080/students. Then no need to use students in @GetMapping("students/{id}").
public class StudentController {

    //-- http://localhost:8080/student
    @GetMapping("student")  //-- Get information from the server
    public Student getStudent(){
        Student student = new Student(1,"Ramesh","Fadatare");
        return student; //-- This returning value will be displayed in JSON Format in the URL
    }

    //-- http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"John","Doe"));
        students.add(new Student(2,"Jane","Doe"));
        students.add(new Student(3,"Mike","Hussy"));
        students.add(new Student(4,"Clara","Hussy"));
        return students;
    }

    //-- Spring Boot REST API with Path Variable.
    //-- {id} - URI template variable
    //-- http://localhost:8080/students/1
    @GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable("id") int studentId){   //-- @PathVariable("id") annotation used to bind a method argument (int studentID) to URI template variable ({id}). If both have same name, no need to define as @PathVariable("id").
        return new Student(studentId,"John","Wick");
    }

    //-- Spring Boot REST API with multiple Path Variables.
    //-- http://localhost:8080/students/1/Mike/Stanford
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariables(@PathVariable("id") int studentId,
                                        @PathVariable("first-name") String studentFName,
                                        @PathVariable("last-name") String studentLName){
        return new Student(studentId,studentFName,studentLName);
    }


    //-- Spring boot REST API with Request Parameters
    //-- http://localhost:8080/students/query?id=1    ?id=1 is a Query parameter
    //-- @RequestParam is used to extract a Query Parameter from a request URL
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id){
        return new Student(id,"Tyler","Rake");
    }

    //-- Spring boot REST API with multiple Request Parameters
    //-- http://localhost:8080/students/queries?id=1&firstName=Jack&lastName=Nicholson    ?id=1&firstName=Jack&lastName=Nicholson are Query parameters
    @GetMapping("students/queries")
    public Student studentRequestVariables(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
        return new Student(id,firstName,lastName);
    }

    //-- Spring boot REST API that handles HTTP POST requests - Creating new resource.
    //-- Need @PostMapping and @RequestBody annotations.
    //-- http://localhost:8080/students/create
    @PostMapping("students/create")    //-- used to map HTTP POST requests onto specific handler method (Use Postman)
    @ResponseStatus(HttpStatus.CREATED)   //-- Provide Response Status "201 Created" to the server
    public Student createStudent(@RequestBody Student student){     //-- @RequestBody will retrieve HTTP request body as a JSON object and convert it to Java Object
        System.out.printf(student.getId() + student.getFirstName() + student.getLastName());
        return student;
    }

    //-- Spring boot REST API that handles HTTP PUT request - Updating existing resource.
    @PutMapping("students/{id}/update") //-- Map incoming HTTP PUT requests (Use Postman for trials) http://localhost:8080/students/2/update
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentID){  //-- The JSON Object that sent is converted to a Java Object by @RequestBody annotation

        student.setId(studentID);
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //-- Spring boot REST API that handles HTTP DELETE requests - Deleting existing resource
    @DeleteMapping("students/{id}/delete")  //-- Map incoming HTTP DELETE requests (Use Postman) http://localhost:8080/students/3/delete
    public String deleteStudent(@PathVariable("id") int studentID){     //-- Here only testing whether HTTP DELETE request comes from Postman with the ID. No actual deletion.
        System.out.println(studentID);
        return "Student deleted successfully";
    }


    //-- http://localhost:8080/studentr
    @GetMapping("studentr")
    public ResponseEntity<Student> getStudentR(){       //-- Using ResponseEntity class to configure response to REST API
        Student student = new Student(1,"Steve","Rodgers");

        //return new ResponseEntity<>(student,HttpStatus.OK);   //-- Can use this way as well.
        //return ResponseEntity.ok(student);    //-- Can use this way as well.
        return ResponseEntity.ok().header("custom-header","steve-rodgers").body(student);   //-- Provides a custom-header (key) metadata in the HTTP response with (value) steve-rodgers.
    }

}
