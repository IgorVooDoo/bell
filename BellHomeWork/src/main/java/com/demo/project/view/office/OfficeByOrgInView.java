package com.demo.project.view.office;

import javax.validation.constraints.NotEmpty;

/**
 * Представление входных данных объекта Office
 * для POST-запроса api/office/list (фильтр по ИД организации)
 *
 * @see com.demo.project.controller.OfficeController
 */
public class OfficeByOrgInView {
    @NotEmpty
    public int orgId;
    public String name;
    public String phone;
    public boolean isActive;


    public String toString() {
        return "{orgId:" + orgId + ";name:" + name + ";}";
    }
}
