package com.demo.project.service;

import com.demo.project.model.Organization;
import com.demo.project.view.organization.OrganizationView;

import java.util.List;

/**
 * Интерфейс сервиса для обработки запросов объекта CountryType
 */
public interface OrganizationService {
    /**
     * Получить все объекты
     *
     * @return
     */
    List<OrganizationView> all();

    /**
     * Поиск по имени
     *
     * @param name
     * @return
     */
    List<OrganizationView> findByName(String name);

    /**
     * Получить объект по идентификатору
     * @param id
     * @return
     */
    OrganizationView findById(int id);

    /**
     * Обновление данных
     * @param org
     * @throws Exception
     */
    void update(Organization org) throws Exception;

    /**
     * Сохранение объекта
     * @param org
     * @throws Exception
     */
    void save(Organization org) throws Exception;
}
