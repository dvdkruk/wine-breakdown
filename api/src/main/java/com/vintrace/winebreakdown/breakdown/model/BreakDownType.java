package com.vintrace.winebreakdown.breakdown.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BreakDownType {
    YEAR,
    VARIETY,
    REGION;

    @JsonValue
    public String getJsonValue() {
        return this.name().toLowerCase();
    }
}
