package com.demo.project.dao;

import com.demo.project.model.CountryType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO для работы с CountryType
 */
@Repository
public interface CountryTypeDao extends CrudRepository<CountryType,Long> {
    /**
     * Получить объект по коду
     *
     * @param code
     * @return
     */
    CountryType findByCode(int code);
}
