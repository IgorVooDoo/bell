package com.demo.project.view.office;

/**
 * Представление входных данных объекта Office
 * для POST-запроса api/office/save
 *
 * @see com.demo.project.controller.OfficeController
 */
public class OfficeSaveView {
    public String name;
    public String address;
    public String phone;
    public boolean isActive;
}
