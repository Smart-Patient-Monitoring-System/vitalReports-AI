package com.example.vitalReports.logic;

import org.springframework.stereotype.Component;

import com.example.vitalReports.domain.enums.HealthStatus;
import com.example.vitalReports.domain.model.VitalReading;
import com.example.vitalReports.domain.model.VitalStatus;

@Component
public class AIVitalEvaluator implements VitalDecisionEngine {

    @Override
    public VitalStatus evaluate(VitalReading reading) {
        // 🔴 This is a placeholder for a real ML model
        // Later: call Python ML service / ONNX / TensorFlow model

        return new VitalStatus(
                HealthStatus.AVERAGE,
                HealthStatus.AVERAGE,
                HealthStatus.AVERAGE,
                HealthStatus.AVERAGE
        );
    }
}
