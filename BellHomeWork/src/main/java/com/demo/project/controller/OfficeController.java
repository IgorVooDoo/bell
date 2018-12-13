package com.demo.project.controller;

import com.demo.project.service.OfficeService;
import com.demo.project.view.office.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class OfficeController {
    private final OfficeService service;

    public OfficeController(OfficeService service) {
        this.service = service;
    }

    @GetMapping("/office/all")
    public List<OfficeView> all() {
        return service.all();
    }

    @GetMapping("/office")
    public OfficeByIdOutView getById(@RequestParam int id) {
        return service.loadById(id);
    }

    @PostMapping("/office/list")
    public List<OfficeByOrgOutView> findByIdOrg(@RequestBody OfficeByOrgInView req) {
        return service.findByOrg(req.orgId);
    }

    @PostMapping("office/save")
    public ResponseEntity add(@RequestBody OfficeSaveView req) {
        try {
            service.save(req);
            return new ResponseEntity("{\"result\":\"success\"}", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity("{\"result\":\"" + ex.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("office/update")
    public ResponseEntity update(@RequestBody OfficeUpdateView req) {
        try {
            service.update(req);
            return new ResponseEntity("{\"result\":\"success\"}", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity("{\"result\":\"" + ex.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }

    }




}
