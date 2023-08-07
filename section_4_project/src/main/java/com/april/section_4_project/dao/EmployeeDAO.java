package com.april.section_4_project.dao;

import com.april.section_4_project.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public Employee save(Employee emp);

    public List<Employee> getAll();

    public Employee get(Integer id);

    public void delete(Integer id);

}
