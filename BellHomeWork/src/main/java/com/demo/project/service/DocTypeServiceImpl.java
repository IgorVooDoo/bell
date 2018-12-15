package com.demo.project.service;

import com.demo.project.dao.DocTypeDao;
import com.demo.project.model.DocType;
import com.demo.project.model.mapper.MapperFacade;
import com.demo.project.view.DocTypeView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocTypeServiceImpl implements DocTypeService {
    private final DocTypeDao dao;
    private final MapperFacade mP;

    public DocTypeServiceImpl(DocTypeDao dao, MapperFacade mF) {
        this.dao = dao;
        this.mP = mF;
    }

    @Override
    public List<DocTypeView> all() {
        Iterable<DocType> all = dao.findAll();
        return mP.mapAsList(all, DocTypeView.class);
    }

    @Override
    public DocTypeView findByCode(int code) {
        DocType all = dao.findByCode(code);
        return mP.map(all, DocTypeView.class);

    }
}
