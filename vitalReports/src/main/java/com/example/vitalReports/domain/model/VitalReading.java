package com.example.vitalReports.domain.model;

public class VitalReading {

    private int spo2;
    private int systolicBP;
    private int heartRate;
    private double temperature;
    private long timestamp;

    public VitalReading() {}

    public VitalReading(int spo2, int systolicBP, int heartRate,
                        double temperature, long timestamp) {
        this.spo2 = spo2;
        this.systolicBP = systolicBP;
        this.heartRate = heartRate;
        this.temperature = temperature;
        this.timestamp = timestamp;
    }

    public int getSpo2() {
        return spo2;
    }

    public int getSystolicBP() {
        return systolicBP;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public double getTemperature() {
        return temperature;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
