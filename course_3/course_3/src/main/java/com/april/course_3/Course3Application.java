package com.april.course_3;

import com.april.course_3.dao.StudentDAO;
import com.april.course_3.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;
import java.util.List;

@SpringBootApplication
public class Course3Application {

	public static void main(String[] args) {
		SpringApplication.run(Course3Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner -> {
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudent(studentDAO);

		};
	}

	private void createMultipleStudents(StudentDAO studentDAO)
	{
		Student student1 = new Student("Abdullah", "Aslan", "abdullah@aslan.com");
		Student student2 = new Student("Murat", "Inan", "murti@inan.com");
		Student student3 = new Student("Veysel", "Gorciz", "veyso@grcz.com");

		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

	}

	private void createStudent(StudentDAO studentDAO)
	{
		Student student = new Student("Abdullah", "Aslan", "abdullah@aslan.com");

		studentDAO.save(student);
	}

	private void readStudent(StudentDAO studentDAO)
	{
		System.out.println(studentDAO.findById(1));
	}

	private void queryForStudents(StudentDAO studentDAO)
	{
		List<Student> sl = studentDAO.findAll();

		for (Student s :
				sl) {
			System.out.println(s);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO)
	{
		List<Student> sl = studentDAO.findByLastName("Aslan");

		for (Student s :
				sl) {
			System.out.println(s);
		}
	}

	private void updateStudent(StudentDAO studentDAO)
	{
		int id = 1;
		Student student = studentDAO.findById(id);

		student.setEmail("abd@changed.com");
		studentDAO.update(student);
	}

	private void deleteStudent(StudentDAO studentDAO)
	{
		int id = 3;
		studentDAO.delete(3);
	}

	private void deleteAllStudent(StudentDAO studentDAO)
	{
		studentDAO.deleteAll();
	}

}
