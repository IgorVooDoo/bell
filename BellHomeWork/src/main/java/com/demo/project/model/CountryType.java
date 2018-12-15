package com.demo.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CountryType {

    @Id
    private int code;
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
