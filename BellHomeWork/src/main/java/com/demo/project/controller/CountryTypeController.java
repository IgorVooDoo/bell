package com.demo.project.controller;

import com.demo.project.service.CountryTypeService;
import com.demo.project.view.CountryTypeView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api", produces = APPLICATION_JSON_VALUE)
public class CountryTypeController {
    private final CountryTypeService service;

    public CountryTypeController(CountryTypeService service) {
        this.service = service;
    }

    @GetMapping("/countries")
    public List<CountryTypeView> all(){
        return service.all();
    }
}
