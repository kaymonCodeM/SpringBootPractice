package com.mail.Maildemo.Service;

import com.mail.Maildemo.Entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private HibernateConfig hibernateConfig;


    @Override
    public List<Student> getStudents() {
        hibernateConfig.connect();
        Session session = hibernateConfig.getSession();
        Query query = session.createQuery("from Student");
        List<Student> students = query.list();
        hibernateConfig.commit();
        return students;
    }

    @Override
    public String addStudent(Student student) {
        hibernateConfig.connect();
        Session session = hibernateConfig.getSession();
        session.save(student);
        hibernateConfig.commit();
        return "Successfully Added Student:\n" + student;
    }

    @Override
    public Student selectStudent(int studentId) {
        hibernateConfig.connect();
        Session session = hibernateConfig.getSession();
        Student student = null;
        try {
            student = session.get(Student.class,studentId);
        }catch (Exception e){
            System.out.println("Did not find Student by id: " + studentId);
        }finally {
            hibernateConfig.commit();
        }
        return student;
    }

    @Override
    public String updateStudent(Student student) {
        hibernateConfig.connect();
        Session session = hibernateConfig.getSession();
        try {
            session.update(student);
        }catch (Exception e){
            System.out.println("Not able to update Student:\n"+ student);
        }finally {
            hibernateConfig.commit();
        }
        return "Update Successful:\n" + student;
    }

    @Override
    public String deleteStudent(int studentId) {
        hibernateConfig.connect();
        Session session = hibernateConfig.getSession();
        try {
            Student s = new Student();
            s.setId(studentId);
            session.delete(s);
        }catch (Exception e){
            System.out.println("Delete Failed by id: " + studentId);
        }finally {
            hibernateConfig.commit();
        }
        return "Delete Successful by id: " + studentId;
    }

}
