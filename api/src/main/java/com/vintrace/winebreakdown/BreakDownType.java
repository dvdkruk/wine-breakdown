package com.vintrace.winebreakdown;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BreakDownType {
    YEAR,
    VARIETY;

    @JsonValue
    public String getJsonValue() {
        return this.name().toLowerCase();
    }
}
