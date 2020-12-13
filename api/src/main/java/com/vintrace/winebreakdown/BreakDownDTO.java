package com.vintrace.winebreakdown;

import java.util.List;

public class BreakDownDTO {

    private final BreakDownType breakDownType;
    private final List<BreakDownElementDTO> breakdown;

    public BreakDownDTO(BreakDownType breakDownType, List<BreakDownElementDTO> elements) {
        this.breakDownType = breakDownType;
        this.breakdown = elements;
    }

    public BreakDownType getBreakDownType() {
        return breakDownType;
    }

    public List<BreakDownElementDTO> getBreakdown() {
        return breakdown;
    }
}
