package com.demo.project.service;

import com.demo.project.view.CountryTypeView;

import java.util.List;

public interface CountryTypeService {
    List<CountryTypeView> all();

    CountryTypeView findByCode(int code);
}
