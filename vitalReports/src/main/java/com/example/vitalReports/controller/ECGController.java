package com.example.vitalReports.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.vitalReports.domain.model.ECGPredictionResponse;
import com.example.vitalReports.service.ECGPredictionService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ecg")
@CrossOrigin
public class ECGController {

    private final ECGPredictionService ecgPredictionService;

    public ECGController(ECGPredictionService ecgPredictionService) {
        this.ecgPredictionService = ecgPredictionService;
    }

    @PostMapping("/predict")
    public ResponseEntity<ECGPredictionResponse> predictECG(
            @RequestBody Map<String, List<Double>> body) throws Exception {

        List<Double> signal = body.get("signal");

        if (signal == null || signal.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        ECGPredictionResponse result = ecgPredictionService.predictECG(signal);
        return ResponseEntity.ok(result);
    }
}
