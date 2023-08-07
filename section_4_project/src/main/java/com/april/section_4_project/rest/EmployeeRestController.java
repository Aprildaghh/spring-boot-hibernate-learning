package com.april.section_4_project.rest;

import com.april.section_4_project.dao.EmployeeDAO;
import com.april.section_4_project.entity.Employee;
import com.april.section_4_project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees()
    {
        return employeeService.getAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee emp =  employeeService.get(employeeId);

        if(emp == null)
            throw new RuntimeException("Employee id not found - " + employeeId);

        return emp;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee emp)
    {
        emp.setId(0);

        Employee dbEmp = employeeService.save(emp);

        // return dbEmp bc of updated id
        return dbEmp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp)
    {
        Employee dbEmp = employeeService.save(emp);
        return dbEmp;
    }

    @DeleteMapping("/employees/{empId}")
    public String deleteEmployee(@PathVariable int empId)
    {
        Employee emp = employeeService.get(empId);

        if(emp == null)
            throw new RuntimeException("Employee id not found - " + empId);

        employeeService.delete(empId);

        return "Deleted employee id - " + empId;
    }

}
