package com.demo.project.view.organization;

import javax.validation.constraints.NotEmpty;

/**
 * Представление входных данных объекта Organization
 * для POST-запроса api/organization/update
 *
 * @see com.demo.project.controller.OrganizationController
 */
public class OrganizationUpdateView {
    @NotEmpty
    public int id;
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
