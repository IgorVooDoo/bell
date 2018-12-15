package com.demo.project.controller;

import com.demo.project.model.Organization;
import com.demo.project.service.OrganizationService;
import com.demo.project.view.organization.OrganizationView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {
    private final OrganizationService service;

    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @GetMapping("/organizations")
    public List<OrganizationView> all() {
        return service.all();
    }

    @PostMapping("/organization/list")
    public List<OrganizationView> filter(@RequestBody Organization org) {
        return service.findByName(org.getName());
    }

    @GetMapping("/organization")
    public OrganizationView getOrgById(@RequestParam int id) {
        return service.findById(id);
    }

    @PostMapping("/organization/update")
    public ResponseEntity update(@RequestBody Organization org) {
        try {
            service.update(org);
            return new ResponseEntity("{\"result\":\"success\"}", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity("{\"result\":\"" + ex.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/organization/save")
    public ResponseEntity save(@RequestBody Organization org) {
        try {
            service.save(org);
            return new ResponseEntity("{\"result\":\"success\"}", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity("{\"result\":\"" + ex.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
    }

}
