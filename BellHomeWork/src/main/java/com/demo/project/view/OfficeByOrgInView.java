package com.demo.project.view;

import javax.validation.constraints.NotEmpty;

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
