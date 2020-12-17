package com.vintrace.api.breakdown.domain.models;

public class BreakDownElement {

    private final Double percentage;
    private final String key;

    public BreakDownElement(Double percentage, String key) {
        this.percentage = percentage;
        this.key = key;
    }

    public Double getPercentage() {
        return percentage;
    }

    public String getKey() {
        return key;
    }
}
