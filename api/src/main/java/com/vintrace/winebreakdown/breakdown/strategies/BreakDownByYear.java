package com.vintrace.winebreakdown.breakdown.strategies;

import com.vintrace.winebreakdown.breakdown.model.BreakDown;
import com.vintrace.winebreakdown.breakdown.model.BreakDownElement;
import com.vintrace.winebreakdown.breakdown.model.BreakDownType;
import com.vintrace.winebreakdown.wine.Wine;
import com.vintrace.winebreakdown.wine.WineComponent;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

@Component
class BreakDownByYear implements BreakDownStrategy {
    @Override
    public BreakDownType getType() {
        return BreakDownType.YEAR;
    }

    @Override
    public BreakDown convert(Wine wine) {
        List<BreakDownElement> elements = wine.getComponents().stream()
                .collect(Collectors.groupingBy(WineComponent::getYear))
                .entrySet().stream()
                .map(k -> createBreakDownElement(k.getKey(), k.getValue()))
                .collect(Collectors.toList());
        return new BreakDown(getType(), elements);
    }

    private BreakDownElement createBreakDownElement(Integer year, List<WineComponent> components) {
        Double percentage = components.stream()
                .map(WineComponent::getPercentage)
                .reduce(0D, Double::sum);
        String formattedPercentage = DecimalFormat.getNumberInstance().format(percentage);
        return new BreakDownElement(formattedPercentage, year.toString());
    }
}
