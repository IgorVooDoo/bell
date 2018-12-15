package com.demo.project.service;

import com.demo.project.dao.CountryTypeDao;
import com.demo.project.dao.DocTypeDao;
import com.demo.project.dao.EmployeeDao;
import com.demo.project.model.Document;
import com.demo.project.model.Employee;
import com.demo.project.model.mapper.MapperFacade;
import com.demo.project.view.employee.EmployeeByOfficeIdOutView;
import com.demo.project.view.employee.EmployeeSaveView;
import com.demo.project.view.employee.EmployeeUpdateView;
import com.demo.project.view.employee.EmployeeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao dao;
    private final MapperFacade mF;
    private final DocTypeDao docTypeDao;
    private final CountryTypeDao countryTypeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao dao, CountryTypeDao countryTypeDao, DocTypeDao docType, MapperFacade mF) {
        this.dao = dao;
        this.mF = mF;
        this.docTypeDao = docType;
        this.countryTypeDao = countryTypeDao;

    }

    @Override
    public List<EmployeeView> all() {
        Iterable<Employee> all = dao.findAll();
        return mF.mapAsList(all, EmployeeView.class);
    }

    @Override
    public EmployeeByOfficeIdOutView findById(int id) {
        Employee all = dao.findById(id);
        return mF.map(all, EmployeeByOfficeIdOutView.class);
    }

    @Override
    public List<EmployeeByOfficeIdOutView> findByOffice(int id) {
        Iterable<Employee> all = dao.findByOffice(id);
        return mF.mapAsList(all, EmployeeByOfficeIdOutView.class);
    }

    @Override
    @Transactional
    public void save(EmployeeSaveView employee) {
        Employee emp = new Employee();
        Document doc = new Document();

        emp.setFirstName(employee.firstName);
        emp.setLastName(employee.lastName);
        emp.setMiddleName(employee.middleName);
        emp.setPosition(employee.position);
        emp.setPhone(employee.phone);
        emp.setIsIdentified(employee.isIdentified);
        doc.setDocNumber(employee.docNumber);
        doc.setDocDate(employee.docDate);
        doc.setType(docTypeDao.findByCode(employee.docCode));
        emp.setDocument(doc);
        emp.setCountryType(countryTypeDao.findByCode(employee.citizenshipCode));
        dao.save(emp);
    }

    @Override
    public void update(EmployeeUpdateView employee) {
        Employee emp = dao.findById(employee.id);
        Document doc = emp.getDocument();

        emp.setFirstName(employee.firstName);
        emp.setLastName(employee.lastName);
        emp.setMiddleName(employee.middleName);
        emp.setPosition(employee.position);
        emp.setPhone(employee.phone);
        emp.setIsIdentified(employee.isIdentified);
        doc.setDocNumber(employee.docNumber);
        doc.setDocDate(employee.docDate);
        emp.setDocument(doc);
        emp.setCountryType(countryTypeDao.findByCode(employee.citizenshipCode));
        dao.save(emp);
    }
}
