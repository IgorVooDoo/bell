package com.demo.project.dao;

import com.demo.project.model.Organization;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganizationDao extends CrudRepository<Organization,Long> {
    List<Organization> findByName(String name);
    Organization findById(int id);
}
