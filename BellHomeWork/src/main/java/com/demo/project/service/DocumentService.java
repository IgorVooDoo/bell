package com.demo.project.service;

import com.demo.project.view.DocumentView;

import java.util.List;

/**
 * Интерфейс сервиса для обработки запросов объекта CountryType
 */
public interface DocumentService {
    /**
     * Получить все объекты
     *
     * @return
     */
    List<DocumentView> all();
}
