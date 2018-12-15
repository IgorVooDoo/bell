package com.demo.project.view.organization;

import javax.validation.constraints.NotEmpty;

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
