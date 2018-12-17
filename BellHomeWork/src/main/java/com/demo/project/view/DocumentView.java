package com.demo.project.view;

import com.demo.project.model.DocType;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * Представление данных объекта Document
 * для GET-запроса /api/documents
 *
 * @see com.demo.project.controller.DocumentController
 */
public class DocumentView {

    @NotEmpty
    private int id;
    @NotEmpty
    public int docNumber;
    @NotEmpty
    public Date docDate;
    @NotEmpty
    public DocType type;

    @Override
    public String toString(){
        return "{id:" + id + ";docNumber:" + docNumber + ";docDate:}";

    }
}
