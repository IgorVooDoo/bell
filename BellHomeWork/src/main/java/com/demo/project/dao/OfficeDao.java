package com.demo.project.dao;

import com.demo.project.model.Office;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO для работы с Office
 */
@Repository
public interface OfficeDao extends CrudRepository<Office, Long> {
    /**
     * Получить объект по идентификатора
     *
     * @param id
     * @return
     */
    Office findById(int id);

    /**
     * Поиск по идентификатору организации
     * @param orgId
     * @return
     */
    @Query("select a from Office a join a.organization c where c.id=:orgId")
    List<Office> findByOrg(@Param("orgId") int orgId);


}
