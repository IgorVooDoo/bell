package com.demo.project.view;

import com.demo.project.model.CountryType;
import com.demo.project.model.Document;
import com.demo.project.model.Office;

import javax.validation.constraints.NotEmpty;

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
