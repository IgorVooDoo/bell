package com.demo.project.controller;

import com.demo.project.service.EmployeeService;
import com.demo.project.view.employee.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("employee/save")
    public ResponseEntity add(@RequestBody EmployeeSaveView emp) {
        try {
            service.save(emp);
            return new ResponseEntity("{\"result\":\"success\"}", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity("{\"result\":\"" + ex.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("employee/update")
    public ResponseEntity update(@RequestBody EmployeeUpdateView emp) {
        try {
            service.update(emp);
            return new ResponseEntity("{\"result\":\"success\"}", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity("{\"result\":\"" + ex.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
    }
}
