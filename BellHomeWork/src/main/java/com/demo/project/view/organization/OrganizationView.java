package com.demo.project.view.organization;

import javax.validation.constraints.NotEmpty;

/**
 * Представление данных объекта Organization
 * для POST-запроса api/organization/list
 *
 * @see com.demo.project.controller.OrganizationController
 */
public class OrganizationView {
    @NotEmpty
    public int id;
    public String name;
    public String fullName;
    public String address;
    public String phone;
    public long inn;
    public long kpp;
    public boolean isActive;

    public String toString(){
        return "{id:"+id+";name:"+name+";}";
    }
}
