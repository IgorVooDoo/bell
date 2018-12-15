package com.demo.project.service;

import com.demo.project.view.employee.EmployeeByOfficeIdOutView;
import com.demo.project.view.employee.EmployeeSaveView;
import com.demo.project.view.employee.EmployeeUpdateView;
import com.demo.project.view.employee.EmployeeView;

import java.util.List;

public interface EmployeeService {
    List<EmployeeView> all();

    EmployeeByOfficeIdOutView findById(int id);

    List<EmployeeByOfficeIdOutView> findByOffice(int officeId);

    void save(EmployeeSaveView employee) throws Exception;

    void update(EmployeeUpdateView employee) throws Exception;
}
