package com.genspark.SpringBootDemoApp.Dao;

import com.genspark.SpringBootDemoApp.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<Course,Integer> {
}
