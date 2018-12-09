package com.demo.project.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class DocTypeView {
    @NotEmpty
    private int id;
    @Size(max=45)
    @NotEmpty(message = "Наименование документа cannot be null")
    public String name;
    @NotEmpty(message = "Код cannot be null")
    public int code;

    @Override
    public String toString(){
        return "{id:" + id + ";name:" + name + ";code:" + code + "}";
    }
}
