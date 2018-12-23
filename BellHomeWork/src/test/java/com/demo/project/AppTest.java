package com.demo.project;


import com.demo.project.model.Organization;
import com.demo.project.model.mapper.MapperFacade;
import com.demo.project.view.organization.OrganizationSaveView;
import com.demo.project.view.organization.OrganizationUpdateView;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Тестирование запросов
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AppTest {
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
     * Получение списка всех документов
     *
     * @throws Exception
     */
    @Test
    public void documentAllTest() throws Exception {
        this.mockMvc.perform(get("/api/documents"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Получение списка типа всех документов
     * @throws Exception
     */
    @Test
    public void documentTypeAllTest() throws Exception {
        this.mockMvc.perform(get("/api/docs"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Получение списка всех стран
     * @throws Exception
     */
    @Test
    public void countryTypeAllTest() throws Exception {
        this.mockMvc.perform(get("/api/countries"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Список всех организаций
     * @throws Exception
     */
    @Test
    public void organizationAllTest() throws Exception {
        this.mockMvc.perform(get("/api/organizations"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Фильтр по наименованию организации
     * @throws Exception
     */
    @Test
    public void organizationFilterNameTest() throws Exception {
        Organization org = new Organization();
        org.setName("Java");
        this.mockMvc.perform(post("/api/organization/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(org)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Поиск организации по идентификатору
     * @throws Exception
     */
    @Test
    public void organizationGetByIdTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/organization?id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Java"));
    }

    /**
     * Сохранение организации
     * @throws Exception
     */
    @Test
    public void organizationSaveTest() throws Exception {
        OrganizationSaveView req = new OrganizationSaveView();
        req.name = "JPA";
        req.fullName = "JPA API";
        req.address = "JDK 1.8";
        req.isActive = true;
        req.phone = "9189788877";
        req.inn = 7777777;
        req.kpp = 55555;
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/organization/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(req)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Обновление организации
     * @throws Exception
     */
    @Test
    public void organizationUpdateTest() throws Exception {
        OrganizationUpdateView req = new OrganizationUpdateView();
        req.id = 2;
        req.name = "Spring";
        req.fullName = "Spring Boot";
        req.address = "SinCity";
        req.isActive = true;
        req.phone = "9189788877";
        req.inn = 233777777;
        req.kpp = 555454555;
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/organization/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(req)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
