package com.april.section_4_project.service;

import com.april.section_4_project.dao.EmployeeDAO;
import com.april.section_4_project.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public Employee save(Employee emp)
    {
        return employeeDAO.save(emp);
    }

    @Override
    public List<Employee> getAll()
    {
        return employeeDAO.getAll();
    }

    @Override
    public Employee get(Integer id)
    {
        return employeeDAO.get(id);
    }

    @Override
    @Transactional
    public void delete(Integer id)
    {
        employeeDAO.delete(id);
    }

}
