package com.demo.project.service;

import com.demo.project.dao.CountryTypeDao;
import com.demo.project.model.CountryType;
import com.demo.project.model.mapper.MapperFacade;
import com.demo.project.view.CountryTypeView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryTypeServiseImpl implements CountryTypeService {
    private final CountryTypeDao dao;
    private final MapperFacade mF;

    public CountryTypeServiseImpl(CountryTypeDao dao, MapperFacade mF) {
        this.dao = dao;
        this.mF = mF;
    }

    @Override
    public List<CountryTypeView> all() {
        Iterable<CountryType> all = dao.findAll();
        return mF.mapAsList(all,CountryTypeView.class);
    }
}
