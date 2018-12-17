package com.demo.project.view.office;

import com.demo.project.model.Organization;

import javax.validation.constraints.NotEmpty;

/**
 * Представление данных объекта Office
 * для POST-запроса api/office/all
 *
 * @see com.demo.project.controller.OfficeController
 */
public class OfficeView {
    @NotEmpty
    public int id;
    public String name;
    public String address;
    public String phone;
    public boolean isActive;
    public Organization organization;

    public String toString(){
        return "{id:"+id+";name:"+name+";}";
    }
}
