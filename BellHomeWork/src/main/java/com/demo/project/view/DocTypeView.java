package com.demo.project.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class DocTypeView {
    @Size(max=45)
    @NotEmpty(message = "Наименование документа cannot be null")
    public String name;
    @NotEmpty(message = "Код cannot be null")
    public int code;

    @Override
    public String toString(){
        return "name:" + name + ";code:" + code + "}";
    }
}
