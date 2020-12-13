package com.vintrace.winebreakdown;

public class WineComponent {

    private final double percentage;
    private final int year;

    public WineComponent(double percentage, int year) {

        this.percentage = percentage;
        this.year = year;
    }

    public double getPercentage() {
        return percentage;
    }

    public int getYear() {
        return year;
    }
}
