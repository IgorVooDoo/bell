package com.demo.project.view.office;

import javax.validation.constraints.NotEmpty;

public class OfficeUpdateView {
    @NotEmpty
    public int id;
    @NotEmpty
    public String name;
    @NotEmpty
    public String adress;
    public String phone;
    public boolean isActive;

}
