package com.demo.project.service;

import com.demo.project.dao.CountryTypeDao;
import com.demo.project.model.CountryType;
import com.demo.project.model.mapper.MapperFacade;
import com.demo.project.view.CountryTypeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Реализация интерфейса
 */
@Service
public class CountryTypeServiseImpl implements CountryTypeService {
    private final CountryTypeDao dao;
    private final MapperFacade mF;

    /**
     * Конструктор с параметрами
     *
     * @param dao
     * @param mF
     */
    @Autowired
    public CountryTypeServiseImpl(CountryTypeDao dao, MapperFacade mF) {
        this.dao = dao;
        this.mF = mF;
    }

    @Override
    public List<CountryTypeView> all() {
        Iterable<CountryType> all = dao.findAll();
        return mF.mapAsList(all,CountryTypeView.class);
    }

    @Override
    public CountryTypeView findByCode(int code) {
        CountryType all = dao.findByCode(code);
        return mF.map(all, CountryTypeView.class);
    }
}
