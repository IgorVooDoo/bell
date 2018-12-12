package com.demo.project.view;

import javax.validation.constraints.NotEmpty;

public class OfficeByOrgOutView {
    @NotEmpty
    public int id;
    public String name;
    public boolean isActive;


    public String toString() {
        return "{id:" + id + ";name:" + name + ";}";
    }
}
