package com.vintrace.winebreakdown;

public class WineComponent {

    private final double percentage;
    private final Integer year;

    public WineComponent(double percentage, Integer year) {

        this.percentage = percentage;
        this.year = year;
    }

    public double getPercentage() {
        return percentage;
    }

    public Integer getYear() {
        return year;
    }
}
