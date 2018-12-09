package com.demo.project.controller;

import com.demo.project.service.DocumentService;
import com.demo.project.view.DocumentView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api", produces = APPLICATION_JSON_VALUE)
public class DocumentController {
    private final DocumentService service;

    public DocumentController(DocumentService service) {
        this.service = service;
    }
    @GetMapping("/documents")
    public List<DocumentView> all(){return service.all();}



}
