package com.demo.project.service;

import com.demo.project.dao.OfficeDao;
import com.demo.project.model.Office;
import com.demo.project.model.mapper.MapperFacade;
import com.demo.project.view.OfficeByOrgOutView;
import com.demo.project.view.OfficeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao dao;
    private final MapperFacade mF;

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
}
