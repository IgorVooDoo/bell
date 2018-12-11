package com.demo.project.controller;

import com.demo.project.model.Organization;
import com.demo.project.service.OrganizationService;
import com.demo.project.view.OrganizationView;
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
    public OrganizationView update(@RequestBody Organization org) {
        return service.update(org);
    }

    @PostMapping("/organization/save")
    public OrganizationView save(@RequestBody Organization org) {
        return service.save(org);
    }

}
