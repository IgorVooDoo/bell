package com.demo.project.view.employee;

import com.demo.project.model.CountryType;
import com.demo.project.model.Document;
import com.demo.project.model.Office;

import javax.validation.constraints.NotEmpty;

/**
 * Представление данных объекта Employee
 * для GET-запроса api/employee/all
 *
 * @see com.demo.project.controller.EmployeeController
 */
public class EmployeeView {
    @NotEmpty
    public int id;
    public String firstName;
    public String lastName;
    public String middleName;
    public String position;
    public int isIdentified;
    public Document document;
    public Office office;
    public CountryType countryType;
    public String toString(){
        return "{id:"+id+"; first_name:"+firstName+";}";
    }
}
