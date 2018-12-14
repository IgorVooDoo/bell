package com.demo.project.view.employee;

import javax.validation.constraints.NotEmpty;

public class EmployeeByOfficeIdViewIn {
    @NotEmpty
    public int officeId;
    public String firstName;
    public String lastName;
    public String middleName;
    public String position;
    public int docCode;
    public int citizenshipCode;

    public String toString() {
        return "{id:" + officeId + "; first_name:" + firstName + ";}";
    }
}
