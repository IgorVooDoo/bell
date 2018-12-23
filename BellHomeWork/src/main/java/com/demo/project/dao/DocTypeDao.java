package com.demo.project.dao;

import com.demo.project.model.DocType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO для работы с DocType
 */
@Repository
public interface DocTypeDao extends CrudRepository<DocType,Long> {
    /**
     * Получить объект по коду
     *
     * @param code
     * @return
     */
    DocType findByCode(int code);
}
