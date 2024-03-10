package dev.thilanka.sms.controller;

import dev.thilanka.sms.dto.StudentDto;
import dev.thilanka.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //--Get all Students
    //http://localhost:8080/students
    @GetMapping("/students")
    public String listStudents(Model model){
        List<StudentDto> studentDto = studentService.getAllStudents();
        model.addAttribute("students",studentDto);
        return "students";
        //return ResponseEntity.ok(studentDto);
    }
}
