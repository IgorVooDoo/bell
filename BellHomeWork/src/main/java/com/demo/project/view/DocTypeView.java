package com.demo.project.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Представление данных объекта DocType
 * для GET-запроса api/docs
 *
 * @see com.demo.project.controller.DocTypeController
 */
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
