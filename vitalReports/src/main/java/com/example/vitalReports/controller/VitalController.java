package com.example.vitalReports.controller;

import org.springframework.web.bind.annotation.*;

import com.example.vitalReports.domain.model.VitalReading;
import com.example.vitalReports.domain.model.VitalStatus;
import com.example.vitalReports.service.VitalProcessingService;

@RestController
@RequestMapping("/api/vitals")
@CrossOrigin // allow frontend / other services
public class VitalController {

    private final VitalProcessingService processingService;

    public VitalController(VitalProcessingService processingService) {
        this.processingService = processingService;
    }

    @PostMapping("/evaluate")
    public VitalStatus evaluateVitals(@RequestBody VitalReading reading) {
        return processingService.process(reading);
    }
}
