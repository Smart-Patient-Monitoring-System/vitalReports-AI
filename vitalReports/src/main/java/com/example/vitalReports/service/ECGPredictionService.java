package com.example.vitalReports.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.vitalReports.domain.model.ECGPredictionResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ECGPredictionService {

    @Value("${ecg.python.path:python}")
    private String pythonPath;

    @Value("${ecg.script.path:ecg_predict.py}")
    private String scriptPath;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ECGPredictionResponse predictECG(List<Double> signal) throws Exception {

        // Build JSON input for the Python script
        Map<String, Object> input = new HashMap<>();
        input.put("signal", signal);
        String jsonInput = objectMapper.writeValueAsString(input);

        // Invoke Python process
        ProcessBuilder pb = new ProcessBuilder(pythonPath, scriptPath, jsonInput);
        pb.redirectErrorStream(false);

        Process process = pb.start();

        // Read stdout (the JSON prediction result)
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        String resultLine = reader.readLine();

        // Read stderr for debugging
        BufferedReader errorReader = new BufferedReader(
                new InputStreamReader(process.getErrorStream()));
        StringBuilder errorOutput = new StringBuilder();
        String errorLine;
        while ((errorLine = errorReader.readLine()) != null) {
            errorOutput.append(errorLine).append("\n");
        }

        int exitCode = process.waitFor();

        if (exitCode != 0 || resultLine == null) {
            throw new RuntimeException(
                    "ECG prediction failed (exit code " + exitCode + "): " + errorOutput);
        }

        // Parse JSON result into response object
        return objectMapper.readValue(resultLine, ECGPredictionResponse.class);
    }
}
