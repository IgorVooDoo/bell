package com.demo.project.controller;

import com.demo.project.service.EmployeeService;
import com.demo.project.service.OfficeService;
import com.demo.project.view.EmployeeView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api", produces = APPLICATION_JSON_VALUE)

public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping("/employee")
    public List<EmployeeView> all(){
        return service.all();
    }
}
