package com.demo.project.service;

import com.demo.project.model.Organization;
import com.demo.project.view.OrganizationView;

import java.util.List;

public interface OrganizationService {
    List<OrganizationView> all();

    List<OrganizationView> findByName(String name);

    OrganizationView findById(int id);

    OrganizationView update(Organization org);

    OrganizationView save(Organization org);
}
