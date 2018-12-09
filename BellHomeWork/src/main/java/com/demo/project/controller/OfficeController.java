package com.demo.project.controller;

import com.demo.project.service.OfficeService;
import com.demo.project.view.OfficeView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api", produces = APPLICATION_JSON_VALUE)
public class OfficeController {
    private final OfficeService service;

    public OfficeController(OfficeService service) {
        this.service = service;
    }
    @GetMapping("/office")
    public List<OfficeView> all(){
        return service.all();
    }
}
