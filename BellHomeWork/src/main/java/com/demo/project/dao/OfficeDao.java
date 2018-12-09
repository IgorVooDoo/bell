package com.demo.project.dao;

import com.demo.project.model.Office;
import org.springframework.data.repository.CrudRepository;

public interface OfficeDao extends CrudRepository<Office,Long> {
}
