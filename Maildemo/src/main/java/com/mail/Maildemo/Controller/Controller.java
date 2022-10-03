package com.mail.Maildemo.Controller;

import com.mail.Maildemo.Entity.Student;
import com.mail.Maildemo.Service.EmailSenderService;
import com.mail.Maildemo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class Controller {

    @Autowired
    StudentService studentService;
    @Autowired
    private EmailSenderService senderService;

    @GetMapping("/sendMail")
    public void sendEmail(){
        String s ="";
        for (Student student: studentService.getStudents()){
            s += student + "\n";
        }
        senderService.sendEmail("spam@gmail.com","My List of Students",s);
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @PostMapping("/students")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/students/{studentId}")
    public Student selectStudent(@PathVariable String studentId){
        return studentService.selectStudent(Integer.parseInt(studentId));
    }

    @PutMapping("/students")
    public String updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable String studentId){
        return studentService.deleteStudent(Integer.parseInt(studentId));
    }


}
