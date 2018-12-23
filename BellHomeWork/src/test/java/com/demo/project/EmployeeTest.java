package com.demo.project;

import com.demo.project.model.mapper.MapperFacade;
import com.demo.project.view.employee.EmployeeByOfficeIdViewIn;
import com.demo.project.view.employee.EmployeeSaveView;
import com.demo.project.view.employee.EmployeeUpdateView;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.GregorianCalendar;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Тест обработки запросов объекта Employee
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeTest {
    private MapperFacade mf;
    @Autowired
    private MockMvc mockMvc;

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Тест получения полного списка
     *
     * @throws Exception
     */
    @Test
    public void employeeAllTest() throws Exception {
        this.mockMvc.perform(get("/api/employee/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Фильтр по офису
     * @throws Exception
     */
    @Test
    public void employeeByOfficeTest() throws Exception {
        EmployeeByOfficeIdViewIn req = new EmployeeByOfficeIdViewIn();
        req.officeId = 1;
        this.mockMvc.perform(post("/api/employee/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(req)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Поиск по идентификатору
     * @throws Exception
     */
    @Test
    public void employeeByIdTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee?id=2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Пушкин"));
    }

    /**
     * Сохранение объекта
     * @throws Exception
     */
    @Test
    public void employeeSaveTest() throws Exception {
        EmployeeSaveView req = new EmployeeSaveView();
        req.firstName = "Васильев";
        req.lastName = "Александр";
        req.middleName = "Георгиевич";
        req.position = "арт";
        req.phone = "+988965548";
        req.docCode = 21;
        req.docDate = (new GregorianCalendar(2007, 06, 15)).getTime();
        req.docNumber = 21255555;
        req.citizenshipCode = 261;
        req.isIdentified = 1;
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(req)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Обновление данных объекта
     * @throws Exception
     */
    @Test
    public void employeeUpdateTest() throws Exception {
        EmployeeUpdateView req = new EmployeeUpdateView();
        req.id = 1;
        req.firstName = "Васильев";
        req.lastName = "Сергей";
        req.middleName = "Петрович";
        req.position = "арт";
        req.phone = "+988965548";
        req.docDate = (new GregorianCalendar(2007, 06, 15)).getTime();
        req.docNumber = 21266666;
        req.citizenshipCode = 261;
        req.isIdentified = 1;
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(req)))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
