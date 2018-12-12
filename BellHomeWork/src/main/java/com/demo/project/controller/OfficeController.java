package com.demo.project.controller;

import com.demo.project.service.OfficeService;
import com.demo.project.view.OfficeByOrgInView;
import com.demo.project.view.OfficeByOrgOutView;
import com.demo.project.view.OfficeView;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/office/list")
    public List<OfficeByOrgOutView> findByIdOrg(@RequestBody OfficeByOrgInView req) {
        return service.findByOrg(req.orgId);
    }
}
