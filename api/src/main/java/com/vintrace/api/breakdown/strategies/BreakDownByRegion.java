package com.vintrace.api.breakdown.strategies;

import com.vintrace.api.breakdown.model.BreakDown;
import com.vintrace.api.breakdown.model.BreakDownElement;
import com.vintrace.api.breakdown.model.BreakDownType;
import com.vintrace.api.storage.model.Wine;
import com.vintrace.api.storage.model.WineComponent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static java.text.NumberFormat.getNumberInstance;
import static java.util.stream.Collectors.*;

@Component
public class BreakDownByRegion implements BreakDownStrategy {
    @Override
    public BreakDownType getType() {
        return BreakDownType.REGION;
    }

    @Override
    public BreakDown convert(Wine wine) {
        List<BreakDownElement> elements = wine.getComponents().stream()
                .collect(groupingBy(WineComponent::getRegion, summingDouble(WineComponent::getPercentage)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .map(kv -> new BreakDownElement(getNumberInstance().format(kv.getValue()), kv.getKey()))
                .collect(toList());
        return new BreakDown(getType(), elements);
    }
}
