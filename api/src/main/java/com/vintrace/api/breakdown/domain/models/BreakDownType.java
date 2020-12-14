package com.vintrace.api.breakdown.domain.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BreakDownType {
    YEAR("year"),
    VARIETY("variety"),
    REGION("region"),
    YEAR_VARIETY("year-variety");

    private final String name;

    BreakDownType(String name) {
        this.name = name;
    }

    @JsonValue
    public String getJsonValue() {
        return this.name;
    }
}
