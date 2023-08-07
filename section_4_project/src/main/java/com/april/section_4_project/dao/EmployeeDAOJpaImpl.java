package com.april.section_4_project.dao;

import com.april.section_4_project.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee save(Employee emp) {
        return entityManager.merge(emp);
    }

    @Override
    public List<Employee> getAll() {

        TypedQuery<Employee> q =
                entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employees = q.getResultList();

        return employees;
    }

    @Override
    public Employee get(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void delete(Integer id) {
        Employee emp = entityManager.find(Employee.class, id);

        entityManager.remove(emp);
    }
}
