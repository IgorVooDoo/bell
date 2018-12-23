package com.demo.project.service;

import com.demo.project.dao.OrganizationDao;
import com.demo.project.model.Organization;
import com.demo.project.model.mapper.MapperFacade;
import com.demo.project.view.organization.OrganizationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Реализация интерфейса
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationDao dao;
    private final MapperFacade mF;

    /**
     * Конструктор с параметрами
     *
     * @param dao
     * @param mF
     */
    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao, MapperFacade mF) {
        this.dao = dao;
        this.mF = mF;
    }

    @Override
    public List<OrganizationView> all() {
        Iterable<Organization> all = dao.findAll();
        return mF.mapAsList(all, OrganizationView.class);
    }

    @Override
    public List<OrganizationView> findByName(String name) {
        Iterable<Organization> all = dao.findByName(name);
        return mF.mapAsList(all, OrganizationView.class);
    }

    @Override
    public OrganizationView findById(int id) {
        Organization all = dao.findById(id);
        return mF.map(all, OrganizationView.class);
    }

    @Override
    public void update(Organization org) {
        Organization all = dao.findById(org.getId());
        all.setName(org.getName());
        all.setFullName(org.getFullName());
        all.setAddress(org.getAddress());
        all.setInn(org.getInn());
        all.setKpp(org.getKpp());
        all.setPhone(org.getPhone());
        all.setIsActive(org.getIsActive());
        dao.save(all);
    }

    @Override
    @Transactional
    public void save(Organization org) {
        Organization all = new Organization();
        all.setName(org.getName());
        all.setFullName(org.getFullName());
        all.setAddress(org.getAddress());
        all.setInn(org.getInn());
        all.setKpp(org.getKpp());
        all.setPhone(org.getPhone());
        all.setIsActive(org.getIsActive());
        dao.save(all);
    }

}
