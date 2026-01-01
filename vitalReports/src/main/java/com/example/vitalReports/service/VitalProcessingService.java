package com.example.vitalReports.service;

import com.example.vitalReports.logic.VitalDecisionEngine;
import org.springframework.stereotype.Service;

import com.example.vitalReports.domain.model.VitalReading;
import com.example.vitalReports.domain.model.VitalStatus;
import com.example.vitalReports.logic.VitalStatusEvaluator;

@Service
public class VitalProcessingService {

    private final VitalDecisionEngine decisionEngine;

    public VitalProcessingService(VitalDecisionEngine decisionEngine) {
        this.decisionEngine = decisionEngine;
    }

    public VitalStatus process(VitalReading reading) {
        return decisionEngine.evaluate(reading);
    }
}
