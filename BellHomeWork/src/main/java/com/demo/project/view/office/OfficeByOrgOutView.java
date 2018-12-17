package com.demo.project.view.office;

import javax.validation.constraints.NotEmpty;

/**
 * Представление данных объекта Office
 * для POST-запроса api/office/list (фильтр по ИД организации)
 *
 * @see com.demo.project.controller.OfficeController
 */
public class OfficeByOrgOutView {
    @NotEmpty
    public int id;
    public String name;
    public boolean isActive;


    public String toString() {
        return "{id:" + id + ";name:" + name + ";}";
    }
}
