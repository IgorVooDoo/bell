package com.demo.project.dao;

import com.demo.project.model.Office;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeDao extends CrudRepository<Office,Long> {

    @Query("select a.id, a.name, a.isActive from Office a join a.organization c where c.id=:orgId")
    List<Office> findByOrg(@Param("orgId") int orgId);
}
