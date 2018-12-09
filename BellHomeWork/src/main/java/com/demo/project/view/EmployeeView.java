package com.demo.project.view;

import javax.validation.constraints.NotEmpty;

public class EmployeeView {
    @NotEmpty
    private int id;
    public String firstName;
    public String lastName;
    public String middleName;
    public String position;
    public int docId;
    public int citizenshipId;
    public int isIdentified;
    public int officeId;

    public String toString(){
        return "{id:"+id+"; first_name:"+firstName+";}";
    }
}
