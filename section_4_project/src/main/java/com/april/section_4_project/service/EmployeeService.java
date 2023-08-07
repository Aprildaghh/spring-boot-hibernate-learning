package com.april.section_4_project.service;

import com.april.section_4_project.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee save(Employee emp);

    public List<Employee> getAll();

    public Employee get(Integer id);

    public void delete(Integer id);

}
