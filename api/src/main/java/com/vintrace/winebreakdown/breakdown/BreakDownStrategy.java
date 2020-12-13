package com.vintrace.winebreakdown.breakdown;

import com.vintrace.winebreakdown.BreakDownDTO;
import com.vintrace.winebreakdown.BreakDownType;
import com.vintrace.winebreakdown.Wine;

interface BreakDownStrategy {
    BreakDownType getType();
    BreakDownDTO convert(Wine wine);
}
