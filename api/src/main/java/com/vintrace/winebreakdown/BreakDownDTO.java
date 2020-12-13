package com.vintrace.winebreakdown;

public class BreakDownDTO {

    private final BreakDownType breakDownType;

    public BreakDownDTO(BreakDownType breakDownType) {
        this.breakDownType = breakDownType;
    }

    public BreakDownType getBreakDownType() {
        return breakDownType;
    }
}
