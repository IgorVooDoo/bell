package com.demo.project.service;

import com.demo.project.dao.OrganizationDao;
import com.demo.project.model.Organization;
import com.demo.project.model.mapper.MapperFacade;
import com.demo.project.view.OrganizationView;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationDao dao;
    private final MapperFacade mF;

    public OrganizationServiceImpl(OrganizationDao dao, MapperFacade mF) {
        this.dao = dao;
        this.mF = mF;
    }

    @Override
    public List<OrganizationView> all(){
        Iterable<Organization> all = dao.findAll();
        return mF.mapAsList(all,OrganizationView.class);
    }

    @Override
    public List<OrganizationView> findByName(String name) {
        Iterable<Organization> all = dao.findByName(name);
        return mF.mapAsList(all,OrganizationView.class);
    }

    @Override
    public OrganizationView findById(int id){
        Organization all = dao.findById(id);
        return mF.map(all,OrganizationView.class);
    }
}
