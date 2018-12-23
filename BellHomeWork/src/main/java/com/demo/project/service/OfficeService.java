package com.demo.project.service;

import com.demo.project.view.office.*;

import java.util.List;

/**
 * Интерфейс сервиса для обработки запросов объекта CountryType
 */
public interface OfficeService {
    /**
     * Получить все объекты
     *
     * @return
     */
    List<OfficeView> all();

    /**
     * Поиск по идентификатору организации
     *
     * @param org
     * @return
     */
    List<OfficeByOrgOutView> findByOrg(int org);

    /**
     * Поиск по идентификатору
     * @param id
     * @return
     */
    OfficeByIdOutView loadById(int id);

    /**
     * Сохранение объекта
     * @param office
     * @throws Exception
     */
    void save(OfficeSaveView office) throws Exception;

    /**
     * Обновление данных объекта
     * @param office
     * @throws Exception
     */
    void update(OfficeUpdateView office) throws Exception;
}
