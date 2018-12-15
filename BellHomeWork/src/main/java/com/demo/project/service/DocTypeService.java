package com.demo.project.service;

import com.demo.project.view.DocTypeView;

import java.util.List;

public interface DocTypeService {
    List<DocTypeView> all();

    DocTypeView findByCode(int code);
}
