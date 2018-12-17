package com.demo.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Таблица - справочник
 * Перечень документов удостоверяющих личность.
 */

@Entity
public class DocType {
    /**
     * Числовой код документа; Уникальный идентификатор;
     */
    @Id
    private int code;
    /**
     * Наименование вида документа;
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
