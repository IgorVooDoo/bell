package com.demo.project.service;

import com.demo.project.dao.OfficeDao;
import com.demo.project.model.Office;
import com.demo.project.model.mapper.MapperFacade;
import com.demo.project.view.office.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Реализация интерфейса
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao dao;
    private final MapperFacade mF;

    /**
     * Конструктор с параметрами
     *
     * @param dao
     * @param mF
     */
    @Autowired
    public OfficeServiceImpl(OfficeDao dao, MapperFacade mF) {
        this.dao = dao;
        this.mF = mF;
    }

    @Override
    public List<OfficeView> all() {
        Iterable<Office> all = dao.findAll();
        return mF.mapAsList(all, OfficeView.class);
    }

    @Override
    public List<OfficeByOrgOutView> findByOrg(int id) {
        Iterable<Office> all = dao.findByOrg(id);
        return mF.mapAsList(all, OfficeByOrgOutView.class);
    }

    @Override
    public OfficeByIdOutView loadById(int id) {
        Office all = dao.findById(id);
        return mF.map(all, OfficeByIdOutView.class);
    }

    @Override
    @Transactional
    public void save(OfficeSaveView office) {
        Office all = new Office();
        all.setName(office.name);
        all.setAddress(office.address);
        all.setPhone(office.phone);
        all.setIsActive(office.isActive);
        dao.save(all);
    }

    @Override
    public void update(OfficeUpdateView office) {
        Office all = dao.findById(office.id);
        all.setName(office.name);
        all.setAddress(office.address);
        all.setPhone(office.phone);
        all.setIsActive(office.isActive);
        dao.save(all);
    }
}
