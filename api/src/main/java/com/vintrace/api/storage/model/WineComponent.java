package com.vintrace.api.storage.model;

public class WineComponent {

    private Double percentage;
    private Integer year;
    private String variety;
    private String region;

    public WineComponent() { }

    public WineComponent(Double percentage, Integer year, String variety, String region) {
        this.percentage = percentage;
        this.year = year;
        this.variety = variety;
        this.region = region;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
