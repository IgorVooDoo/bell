package com.demo.project.dao;

import com.demo.project.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO для работы с Employee
 */
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> {
    /**
     * Получить объект по идентификатору
     *
     * @param id
     * @return
     */
    Employee findById(int id);

    /**
     * Поиск по идентификатору объекта Оffice
     * @param officeId
     * @return
     */
    @Query("select a from Employee a join a.office c where c.id=:officeId")
    List<Employee> findByOffice(@Param("officeId") int officeId);
}
