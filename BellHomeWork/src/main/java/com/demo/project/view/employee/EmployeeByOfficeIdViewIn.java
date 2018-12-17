package com.demo.project.view.employee;

import javax.validation.constraints.NotEmpty;

/**
 * Представление входных данных объекта Employee
 * для POST-запроса api/employee/list (фильтр по ид офиса)
 *
 * @see com.demo.project.controller.EmployeeController
 */
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
