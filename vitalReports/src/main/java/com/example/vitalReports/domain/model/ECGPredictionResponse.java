package com.example.vitalReports.domain.model;

public class ECGPredictionResponse {

    private String prediction;
    private double probability;

    public ECGPredictionResponse() {
    }

    public ECGPredictionResponse(String prediction, double probability) {
        this.prediction = prediction;
        this.probability = probability;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}
