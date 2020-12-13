package com.vintrace.winebreakdown.breakdown.strategies;

import com.vintrace.winebreakdown.breakdown.model.BreakDown;
import com.vintrace.winebreakdown.breakdown.model.BreakDownElement;
import com.vintrace.winebreakdown.breakdown.model.BreakDownType;
import com.vintrace.winebreakdown.storage.model.Wine;
import com.vintrace.winebreakdown.storage.model.WineComponent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static java.text.NumberFormat.getNumberInstance;
import static java.util.stream.Collectors.*;

@Component
class BreakDownByYear implements BreakDownStrategy {
    @Override
    public BreakDownType getType() {
        return BreakDownType.YEAR;
    }

    @Override
    public BreakDown convert(Wine wine) {
        List<BreakDownElement> elements = wine.getComponents().stream()
                .collect(groupingBy(WineComponent::getYear, summingDouble(WineComponent::getPercentage)))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                .map(kv -> new BreakDownElement(getNumberInstance().format(kv.getValue()), kv.getKey().toString()))
                .collect(toList());
        return new BreakDown(getType(), elements);
    }
}
