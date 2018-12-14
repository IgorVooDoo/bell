package com.demo.project.dao;

import com.demo.project.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> {
    Employee findById(int id);

    @Query("select a from Employee a join a.office c where c.id=:officeId")
    List<Employee> findByOffice(@Param("officeId") int officeId);
}
