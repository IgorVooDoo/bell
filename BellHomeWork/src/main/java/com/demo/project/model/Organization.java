package com.demo.project.model;

import javax.persistence.*;

/**
 * Объект таблицы организаций
 */
@Entity
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Наименование организации
     */
    private String name;
    /**
     * Полное наименование организации
     */
    private String fullName;
    /**
     * Адрес организации
     */
    private String address;
    /**
     * Телефон
     */
    private String phone;
    /**
     * ИНН
     */
    private long inn;
    /**
     * КПП
     */
    private long kpp;
    /**
     * Актуальность
     */
    @Column(name = "is_active")
    private boolean isActive;

    public Organization() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getInn() {
        return inn;
    }

    public void setInn(long inn) {
        this.inn = inn;
    }

    public long getKpp() {
        return kpp;
    }

    public void setKpp(long kpp) {
        this.kpp = kpp;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String toString() {
        return "{id:" + id + ";name:" + name + ";}";
    }
}


