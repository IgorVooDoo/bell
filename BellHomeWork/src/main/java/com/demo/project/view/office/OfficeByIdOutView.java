package com.demo.project.view.office;

import javax.validation.constraints.NotEmpty;

/**
 * Представление данных объекта Office
 * для GET-запроса api/office{id} (поиск по ид офиса)
 *
 * @see com.demo.project.controller.OfficeController
 */
public class OfficeByIdOutView {
    @NotEmpty
    public int id;
    public String name;
    public String address;
    public String phone;
    public boolean isActive;

    public String toString() {
        return "{id:" + id + ";name:" + name + ";}";
    }
}
