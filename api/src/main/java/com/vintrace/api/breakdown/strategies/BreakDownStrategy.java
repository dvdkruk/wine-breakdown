package com.vintrace.api.breakdown.strategies;

import com.vintrace.api.breakdown.model.BreakDown;
import com.vintrace.api.breakdown.model.BreakDownType;
import com.vintrace.api.storage.model.Wine;

public interface BreakDownStrategy {
    BreakDownType getType();
    BreakDown convert(Wine wine);
}
