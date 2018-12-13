package com.demo.project.service;

import com.demo.project.view.office.*;

import java.util.List;

public interface OfficeService {
    List<OfficeView> all();
    List<OfficeByOrgOutView> findByOrg(int org);

    OfficeByIdOutView loadById(int id);

    void save(OfficeSaveView office) throws Exception;

    void update(OfficeUpdateView office) throws Exception;
}
