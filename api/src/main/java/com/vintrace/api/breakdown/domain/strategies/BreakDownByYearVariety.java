package com.vintrace.api.breakdown.domain.strategies;

import com.vintrace.api.breakdown.domain.models.BreakDown;
import com.vintrace.api.breakdown.domain.models.BreakDownElement;
import com.vintrace.api.breakdown.domain.models.BreakDownType;
import com.vintrace.api.wine.domain.models.Wine;
import com.vintrace.api.wine.domain.models.WineComponent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static java.text.NumberFormat.getNumberInstance;
import static java.util.stream.Collectors.*;

@Component
class BreakDownByYearVariety implements BreakDownStrategy {
    @Override
    public BreakDownType getType() {
        return BreakDownType.YEAR_VARIETY;
    }

    @Override
    public BreakDown convert(Wine wine) {
        List<BreakDownElement> elements = wine.getComponents().stream()
                .collect(groupingBy(c -> c.getYear() + " - " + c.getVariety(), summingDouble(WineComponent::getPercentage)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .map(kv -> new BreakDownElement(kv.getValue(), kv.getKey()))
                .collect(toList());
        return new BreakDown(getType(), elements);
    }
}
