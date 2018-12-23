package com.demo.project.service;

import com.demo.project.view.employee.EmployeeByOfficeIdOutView;
import com.demo.project.view.employee.EmployeeSaveView;
import com.demo.project.view.employee.EmployeeUpdateView;
import com.demo.project.view.employee.EmployeeView;

import java.util.List;

/**
 * Интерфейс сервиса для обработки запросов объекта CountryType
 */
public interface EmployeeService {
    /**
     * Получить все объекты
     *
     * @return
     */
    List<EmployeeView> all();

    /**
     * Получить объект по идентификатору
     * @param id
     * @return
     */
    EmployeeByOfficeIdOutView findById(int id);

    /**
     * Поиск объектов по идентификатору офисов
     * @param officeId
     * @return
     */
    List<EmployeeByOfficeIdOutView> findByOffice(int officeId);

    /**
     * Сохранение объекта
     * @param employee
     * @throws Exception
     */
    void save(EmployeeSaveView employee) throws Exception;

    /**
     * Окновление данных объекта
     * @param employee
     * @throws Exception
     */
    void update(EmployeeUpdateView employee) throws Exception;
}
