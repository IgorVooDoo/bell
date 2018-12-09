package com.demo.project.dao;

import com.demo.project.model.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentDao extends CrudRepository<Document, Long> {

}
