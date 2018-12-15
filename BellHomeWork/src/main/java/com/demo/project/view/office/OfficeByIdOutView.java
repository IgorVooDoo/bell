package com.demo.project.view.office;

import javax.validation.constraints.NotEmpty;

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
