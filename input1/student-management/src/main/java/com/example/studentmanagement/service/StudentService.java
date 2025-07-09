package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.insertStudent(student);
    }

    public Student findStudentById(Long id) {
        return studentRepository.findStudentById(id);
    }

    public void removeStudent(Long id) {
        studentRepository.deleteStudent(id);
    }

    public List<Student> getRankedStudents() {
        return studentRepository.findRankedStudents();
    }
}