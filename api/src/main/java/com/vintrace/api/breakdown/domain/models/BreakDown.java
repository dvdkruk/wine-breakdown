package com.vintrace.api.breakdown.domain.models;

import java.util.List;

public class BreakDown {

    private final BreakDownType breakDownType;
    private final List<BreakDownElement> breakdown;

    public BreakDown(BreakDownType breakDownType, List<BreakDownElement> elements) {
        this.breakDownType = breakDownType;
        this.breakdown = elements;
    }

    public BreakDownType getBreakDownType() {
        return breakDownType;
    }

    public List<BreakDownElement> getBreakdown() {
        return breakdown;
    }
}
