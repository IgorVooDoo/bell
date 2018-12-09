package com.demo.project.dao;

import com.demo.project.model.DocType;
import org.springframework.data.repository.CrudRepository;

public interface DocTypeDao extends CrudRepository<DocType,Long> {
}
