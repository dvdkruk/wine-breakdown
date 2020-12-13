package com.vintrace.winebreakdown;

public class BreakDownElementDTO {

    private final String percentage;
    private final String key;

    public BreakDownElementDTO(String percentage, String key) {
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
