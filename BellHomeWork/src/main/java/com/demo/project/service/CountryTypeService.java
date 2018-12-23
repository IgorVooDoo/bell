package com.demo.project.service;

import com.demo.project.view.CountryTypeView;

import java.util.List;

/**
 * Интерфейс сервиса для обработки запросов объекта CountryType
 */
public interface CountryTypeService {
    /**
     * Получить все объекты
     *
     * @return
     */
    List<CountryTypeView> all();

    /**
     * Получить объект по коду
     * @param code
     * @return
     */
    CountryTypeView findByCode(int code);
}
