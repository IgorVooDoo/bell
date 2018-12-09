package com.demo.project.service;

import com.demo.project.view.OrganizationView;

import java.util.List;

public interface OrganizationService {
    List<OrganizationView> all();
    List<OrganizationView> findByName(String name);
    OrganizationView findById(int id);
}
