package com.demo.project;


import com.demo.project.model.Organization;
import com.demo.project.model.mapper.MapperFacade;
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
public class AppTest {
    private MapperFacade mf;
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void documentAllTest() throws Exception{
        this.mockMvc.perform(get("/api/documents"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void documentTypeAllTest() throws Exception{
        this.mockMvc.perform(get("/api/docs"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void countryTypeAllTest() throws Exception{
        this.mockMvc.perform(get("/api/countries"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void organizationAllTest() throws Exception{
        this.mockMvc.perform(get("/api/organizations"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void organizationFilterNameTest() throws Exception{
        Organization org = new Organization();
        org.setName("Java");
        this.mockMvc.perform(post("/api/organization/list")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(org)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void organizationGetByIdTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/organization?id=1")
        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Java"));
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
