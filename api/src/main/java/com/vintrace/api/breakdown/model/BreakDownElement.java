package com.vintrace.api.breakdown.model;

public class BreakDownElement {

    private final String percentage;
    private final String key;

    public BreakDownElement(String percentage, String key) {
        this.percentage = percentage;
        this.key = key;
    }

    public String getPercentage() {
        return percentage;
    }

    public String getKey() {
        return key;
    }
}
