package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Optional<Student> getStudentById(Long id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst();
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId().equals(id)) {
                students.set(i, updatedStudent);
                return updatedStudent;
            }
        }
        return null;
    }

    public boolean deleteStudent(Long id) {
        return students.removeIf(student -> student.getId().equals(id));
    }
}