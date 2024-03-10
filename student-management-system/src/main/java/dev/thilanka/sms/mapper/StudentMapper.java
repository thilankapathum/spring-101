package dev.thilanka.sms.mapper;

import dev.thilanka.sms.dto.StudentDto;
import dev.thilanka.sms.entity.Student;

public class StudentMapper {

    //-- Convert Student to StudentDto
    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail());
    }

    //-- Convert StudentDto to Student
    public static Student mapToStudent(StudentDto studentDto){
        return new Student(studentDto.getId(), studentDto.getFirstName(), studentDto.getLastName(), studentDto.getEmail());
    }
}
