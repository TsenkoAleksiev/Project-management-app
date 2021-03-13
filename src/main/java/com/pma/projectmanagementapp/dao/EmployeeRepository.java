package com.pma.projectmanagementapp.dao;

import com.pma.projectmanagementapp.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    public List<Employee> findAll();
}
