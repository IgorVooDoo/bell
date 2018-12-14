package com.demo.project.controller;

import com.demo.project.service.EmployeeService;
import com.demo.project.view.employee.EmployeeByOfficeIdOutView;
import com.demo.project.view.employee.EmployeeByOfficeIdViewIn;
import com.demo.project.view.employee.EmployeeView;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api", produces = APPLICATION_JSON_VALUE)

public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employee/all")
    public List<EmployeeView> all(){
        return service.all();
    }

    @PostMapping("/employee/list")
    public List<EmployeeByOfficeIdOutView> findByOffice(@RequestBody EmployeeByOfficeIdViewIn req) {
        return service.findByOffice(req.officeId);
    }

    @GetMapping("/employee")
    public EmployeeByOfficeIdOutView getById(@RequestParam int id) {
        return service.findById(id);
    }
}
