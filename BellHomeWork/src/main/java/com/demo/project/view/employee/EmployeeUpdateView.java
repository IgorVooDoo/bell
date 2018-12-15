package com.demo.project.view.employee;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class EmployeeUpdateView {
    @NotEmpty
    public int id;
    public String firstName;
    public String lastName;
    public String middleName;
    public String position;
    public String phone;
    public String docName;
    public int docNumber;
    public Date docDate;
    public int citizenshipCode;
    public int isIdentified;

    public String toString() {
        return "{id:" + id + "; first_name:" + firstName + ";}";
    }
}
