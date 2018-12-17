package com.demo.project.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Таблица документов работников
 */
@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Номер документа
     */
    private int docNumber;
    /**
     * Дата выдачи документа
     */
    private Date docDate;
    /**
     * Связь со справочником типов документов
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type")
    private DocType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(int docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public DocType getType() {
        return type;
    }

    public void setType(DocType type) {
        this.type = type;
    }
}
