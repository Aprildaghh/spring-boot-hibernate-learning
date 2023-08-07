package com.april.course_3.dao;

import com.april.course_3.entity.Student;

import java.util.List;

public interface StudentDAO {

    public void save(Student student);

    public Student findById(Integer id);

    public List<Student> findAll();

    public List<Student> findByLastName(String lastName);

    public void update(Student student);

    public void delete(Integer id);

    public int deleteAll();
}
