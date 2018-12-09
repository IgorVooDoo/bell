package com.demo.project.controller;

import com.demo.project.service.DocTypeService;
import com.demo.project.view.DocTypeView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api", produces = APPLICATION_JSON_VALUE)
public class DocTypeController {
    private final DocTypeService service;

    public DocTypeController(DocTypeService service) {
        this.service = service;
    }
    @GetMapping("/docs")
    public List<DocTypeView> all(){return service.all();}

}
