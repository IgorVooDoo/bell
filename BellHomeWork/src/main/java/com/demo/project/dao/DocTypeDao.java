package com.demo.project.dao;

import com.demo.project.model.DocType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocTypeDao extends CrudRepository<DocType,Long> {
    DocType findByCode(int code);
}
