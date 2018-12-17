package com.demo.project.model;

import javax.persistence.*;

/**
 * Объект таблицы сотрудников
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Имя
     */
    private String firstName;
    /**
     * Фамилия
     */
    private String lastName;
    /**
     * Отчество
     */
    private String middleName;
    /**
     * Должность
     */
    private String position;
    /**
     * Телефон сотрудника
     */
    private String phone;
    /**
     * Связь с сотрудника с офисом
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "office_id")
    private Office office;

    /**
     * Связь сотрудника с таблицей документов
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_id")
    private Document document;
    /**
     * Связь сотрудника со справочником стран
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "citizenship_id")
    private CountryType countryType;
    /**
     *
     */
    private int isIdentified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(int isIdentified) {
        this.isIdentified = isIdentified;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public CountryType getCountryType() {
        return countryType;
    }

    public void setCountryType(CountryType countryType) {
        this.countryType = countryType;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

}
