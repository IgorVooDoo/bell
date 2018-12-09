package com.demo.project.service;

import com.demo.project.dao.OfficeDao;
import com.demo.project.model.Office;
import com.demo.project.model.mapper.MapperFacade;
import com.demo.project.view.OfficeView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeDao dao;
    private final MapperFacade mF;

    public OfficeServiceImpl(OfficeDao dao, MapperFacade mF) {
        this.dao = dao;
        this.mF = mF;
    }

    @Override
    public List<OfficeView> all() {
        Iterable<Office> all = dao.findAll();
        return mF.mapAsList(all,OfficeView.class);
    }
}
