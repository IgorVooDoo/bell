package com.demo.project.service;

import com.demo.project.view.employee.EmployeeByOfficeIdOutView;
import com.demo.project.view.employee.EmployeeView;

import java.util.List;

public interface EmployeeService {
    List<EmployeeView> all();

    EmployeeByOfficeIdOutView findById(int id);

    List<EmployeeByOfficeIdOutView> findByOffice(int officeId);
}
