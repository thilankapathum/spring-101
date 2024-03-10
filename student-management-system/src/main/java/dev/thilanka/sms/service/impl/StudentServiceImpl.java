package dev.thilanka.sms.service.impl;

import dev.thilanka.sms.dto.StudentDto;
import dev.thilanka.sms.entity.Student;
import dev.thilanka.sms.mapper.StudentMapper;
import dev.thilanka.sms.repository.StudentRepository;
import dev.thilanka.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> students = studentRepository.findAll();

        /*List<StudentDto> studentDtos = students.stream()
                .map((student) -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());*/

        return students.stream().map(StudentMapper::mapToStudentDto).toList();
    }
}
