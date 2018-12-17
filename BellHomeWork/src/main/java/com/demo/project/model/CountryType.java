package com.demo.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Справочная таблица с перечнем стран
 */
@Entity
public class CountryType {
    /**
     * Числовой код страны; Уникальный идентификатор
     */
    @Id
    private int code;
    /**
     * Наименование страны
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
