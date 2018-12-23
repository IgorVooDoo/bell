package com.demo.project.dao;

import com.demo.project.model.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO для работы с Document
 */
@Repository
public interface DocumentDao extends CrudRepository<Document, Long> {

}
