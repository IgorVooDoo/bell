package com.demo.project.view.employee;

import javax.validation.constraints.NotEmpty;

/**
 * Представление данных объекта Employee
 * для POST-запроса api/employee/list (фильтр по ид офиса)
 *
 * @see com.demo.project.controller.EmployeeController
 */
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
