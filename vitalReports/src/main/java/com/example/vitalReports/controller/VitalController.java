package com.example.vitalReports.controller;

import org.springframework.web.bind.annotation.*;

import com.example.vitalReports.domain.model.VitalReading;
import com.example.vitalReports.domain.model.VitalStatus;
import com.example.vitalReports.service.VitalProcessingService;

@RestController
@RequestMapping("/api/vitals")
@CrossOrigin
public class VitalController {

    private final VitalProcessingService service;

    public VitalController(VitalProcessingService service) {
        this.service = service;
    }

    @PostMapping("/analyze")
    public VitalStatus analyze(@RequestBody VitalReading reading) {
        return service.process(reading);
    }
}
