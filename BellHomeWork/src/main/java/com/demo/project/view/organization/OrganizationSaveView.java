package com.demo.project.view.organization;

import javax.validation.constraints.NotEmpty;

/**
 * Представление входных данных объекта Organization
 * для POST-запроса api/organization/save
 *
 * @see com.demo.project.controller.OrganizationController
 */
public class OrganizationSaveView {
    @NotEmpty
    public String name;
    @NotEmpty
    public String fullName;
    @NotEmpty
    public long inn;
    @NotEmpty
    public long kpp;
    @NotEmpty
    public String address;
    public String phone;
    public boolean isActive;
}
