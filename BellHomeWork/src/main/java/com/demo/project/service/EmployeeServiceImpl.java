package com.demo.project.service;

import com.demo.project.dao.EmployeeDao;
import com.demo.project.model.Employee;
import com.demo.project.model.mapper.MapperFacade;
import com.demo.project.view.EmployeeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao dao;
    private final MapperFacade mF;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao dao, MapperFacade mF) {
        this.dao = dao;
        this.mF = mF;
    }

    @Override
    public List<EmployeeView> all() {
        Iterable<Employee> all=dao.findAll();
        return mF.mapAsList(all,EmployeeView.class);
    }
}
