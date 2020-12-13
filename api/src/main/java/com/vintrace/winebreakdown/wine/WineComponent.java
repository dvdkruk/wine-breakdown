package com.vintrace.winebreakdown.wine;

public class WineComponent {

    private final double percentage;
    private final Integer year;
    private final String variety;
    private final String region;

    public WineComponent(double percentage, Integer year, String variety, String region) {
        this.percentage = percentage;
        this.year = year;
        this.variety = variety;
        this.region = region;
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

    public String getRegion() {
        return region;
    }
}
