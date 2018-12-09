package com.demo.project.view;

import javax.validation.constraints.NotEmpty;

public class OfficeView {
    @NotEmpty
    private int id;
    public String name;
    public String adress;
    public String phone;
    public boolean isActive;
    public String toString(){
        return "{id:"+id+";name:"+name+";}";
    }
}
