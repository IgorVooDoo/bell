package com.demo.project.view.employee;

import javax.validation.constraints.NotEmpty;


public class EmployeeByOfficeIdOutView {
    @NotEmpty
    public int id;
    public String firstName;
    public String lastName;
    public String middleName;
    public String position;

    public String toString() {
        return "{id:" + id + "; first_name:" + firstName + ";}";
    }
}
