package com.demo.project.service;

import com.demo.project.model.Organization;
import com.demo.project.view.organization.OrganizationView;

import java.util.List;

public interface OrganizationService {
    List<OrganizationView> all();

    List<OrganizationView> findByName(String name);

    OrganizationView findById(int id);

    void update(Organization org) throws Exception;

    void save(Organization org) throws Exception;
}
