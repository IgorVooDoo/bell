package com.demo.project.dao;

import com.demo.project.model.CountryType;
import org.springframework.data.repository.CrudRepository;

public interface CountryTypeDao extends CrudRepository<CountryType,Long> {
}
