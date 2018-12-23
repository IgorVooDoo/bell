package com.demo.project.dao;

import com.demo.project.model.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO для работы с Organization
 */
@Repository
public interface OrganizationDao extends CrudRepository<Organization,Long> {
    /**
     * Получить объект по наименованию
     *
     * @param name
     * @return
     */
    List<Organization> findByName(String name);

    /**
     * Получить объект по идентификатору
     * @param id
     * @return
     */
    Organization findById(int id);
}
