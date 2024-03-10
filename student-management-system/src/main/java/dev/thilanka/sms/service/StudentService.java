package dev.thilanka.sms.service;

import dev.thilanka.sms.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();
}
