package com.vintrace.api.breakdown.domain.strategies;

import com.vintrace.api.breakdown.domain.models.BreakDown;
import com.vintrace.api.breakdown.domain.models.BreakDownType;
import com.vintrace.api.wine.domain.models.Wine;

public interface BreakDownStrategy {
    BreakDownType getType();
    BreakDown convert(Wine wine);
}
