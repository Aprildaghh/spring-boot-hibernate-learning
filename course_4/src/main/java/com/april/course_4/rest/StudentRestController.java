package com.april.course_4.rest;

import com.april.course_4.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData()
    {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Abdullah", "Aslan"));
        theStudents.add(new Student("Veyso", "Grcz"));
        theStudents.add(new Student("Murti", "Inan"));
    }


    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        // check if student exist
        if(!(studentId >= 0 && studentId < theStudents.size()))
        {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }

}
