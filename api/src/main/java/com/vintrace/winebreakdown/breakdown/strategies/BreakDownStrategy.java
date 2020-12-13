package com.vintrace.winebreakdown.breakdown.strategies;

import com.vintrace.winebreakdown.breakdown.model.BreakDown;
import com.vintrace.winebreakdown.breakdown.model.BreakDownType;
import com.vintrace.winebreakdown.storage.model.Wine;

public interface BreakDownStrategy {
    BreakDownType getType();
    BreakDown convert(Wine wine);
}
