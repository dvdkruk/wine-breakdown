package com.vintrace.winebreakdown;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BreakDownType {
    YEAR;

    @JsonValue
    public String getJsonValue() {
        return this.name().toLowerCase();
    }
}
