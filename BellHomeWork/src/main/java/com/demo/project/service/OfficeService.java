package com.demo.project.service;

import com.demo.project.view.OfficeByOrgOutView;
import com.demo.project.view.OfficeView;

import java.util.List;

public interface OfficeService {
    List<OfficeView> all();

    List<OfficeByOrgOutView> findByOrg(int org);
}
