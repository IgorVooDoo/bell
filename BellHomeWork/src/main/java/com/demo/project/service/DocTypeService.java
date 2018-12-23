package com.demo.project.service;

import com.demo.project.view.DocTypeView;

import java.util.List;

/**
 * Интерфейс сервиса для обработки запросов объекта CountryType
 */
public interface DocTypeService {
    /**
     * Получить все объекты
     *
     * @return
     */
    List<DocTypeView> all();

    /**
     * Получить объект по коду
     * @param code
     * @return
     */
    DocTypeView findByCode(int code);
}
