package com.demo.project.dao;

import com.demo.project.model.CountryType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryTypeDao extends CrudRepository<CountryType,Long> {
    CountryType findByCode(int code);
}
