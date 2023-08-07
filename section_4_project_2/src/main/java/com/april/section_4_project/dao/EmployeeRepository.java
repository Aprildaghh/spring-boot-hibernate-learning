package com.april.section_4_project.dao;

import com.april.section_4_project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// @RepositoryRestResource(path="member")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
