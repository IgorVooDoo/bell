package com.demo.project;

import com.demo.project.model.mapper.MapperFacade;
import com.demo.project.view.office.OfficeByOrgInView;
import com.demo.project.view.office.OfficeSaveView;
import com.demo.project.view.office.OfficeUpdateView;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OfficeTest {
    private MapperFacade mf;
    @Autowired
    private MockMvc mockMvc;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void officeAllTest() throws Exception {
        this.mockMvc.perform(get("/api/office/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void officeByIdTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/office?id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Java Core"));
    }

    @Test
    public void officeByOrgTest() throws Exception {
        OfficeByOrgInView req = new OfficeByOrgInView();
        req.orgId = 1;
        this.mockMvc.perform(post("/api/office/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(req)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void officeSaveTest() throws Exception {
        OfficeSaveView req = new OfficeSaveView();
        req.name = "Hibernate";
        req.address = "street1";
        req.isActive = true;
        req.phone = "9189788877";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/office/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(req)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void officeUpdateTest() throws Exception {
        OfficeUpdateView req = new OfficeUpdateView();
        req.id = 1;
        req.name = "Java Beans";
        req.phone = "9189788877";
        req.address = "Stark Corp";
        req.isActive = true;
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/office/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(req)))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
