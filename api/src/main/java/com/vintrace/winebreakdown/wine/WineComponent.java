package com.vintrace.winebreakdown.wine;

public class WineComponent {

    private final double percentage;
    private final Integer year;
    private final String variety;

    public WineComponent(double percentage, Integer year, String variety) {

        this.percentage = percentage;
        this.year = year;
        this.variety = variety;
    }

    public double getPercentage() {
        return percentage;
    }

    public Integer getYear() {
        return year;
    }

    public String getVariety() {
        return variety;
    }
}
