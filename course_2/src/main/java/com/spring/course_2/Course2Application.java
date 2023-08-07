package com.spring.course_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.spring.course_2", "com.spring.util"})
public class Course2Application {

	public static void main(String[] args) {
		SpringApplication.run(Course2Application.class, args);
	}

}
