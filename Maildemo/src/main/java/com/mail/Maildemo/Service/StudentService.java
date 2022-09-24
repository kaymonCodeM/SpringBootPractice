package com.mail.Maildemo.Service;

import com.mail.Maildemo.Entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();
    String addStudent(Student student);

    Student selectStudent(int studentId);

    String updateStudent(Student student);

    String deleteStudent(int studentId);
}
