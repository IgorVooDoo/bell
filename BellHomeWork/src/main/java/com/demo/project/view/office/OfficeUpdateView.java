package com.demo.project.view.office;

import javax.validation.constraints.NotEmpty;

/**
 * Представление входных данных объекта Office
 * для POST-запроса api/office/update
 *
 * @see com.demo.project.controller.OfficeController
 */
public class OfficeUpdateView {
    @NotEmpty
    public int id;
    @NotEmpty
    public String name;
    @NotEmpty
    public String address;
    public String phone;
    public boolean isActive;

}
