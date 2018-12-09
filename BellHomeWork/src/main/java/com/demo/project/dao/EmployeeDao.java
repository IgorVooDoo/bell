package com.demo.project.dao;

import com.demo.project.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Long> {
}
