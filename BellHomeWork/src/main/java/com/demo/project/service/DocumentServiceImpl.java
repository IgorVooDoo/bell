package com.demo.project.service;

import com.demo.project.dao.DocumentDao;
import com.demo.project.model.Document;
import com.demo.project.model.mapper.MapperFacade;
import com.demo.project.view.DocumentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Реализация интерфейса
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentDao dao;
    private final MapperFacade mP;

    /**
     * Конструктор с параметрами
     *
     * @param dao
     * @param mP
     */
    @Autowired
    public DocumentServiceImpl(DocumentDao dao, MapperFacade mP) {
        this.dao = dao;
        this.mP = mP;
    }

    @Override
    public List<DocumentView> all() {
        Iterable<Document> all = dao.findAll();
        return mP.mapAsList(all,DocumentView.class);
    }
}
