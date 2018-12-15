package com.demo.project.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CountryTypeView {
    @Size(max=45)
    @NotEmpty
    public String name;
    @NotEmpty
    public int code;

    @Override
    public String toString(){
        return "name:" + name + ";code:" + code + "}";
    }

}
