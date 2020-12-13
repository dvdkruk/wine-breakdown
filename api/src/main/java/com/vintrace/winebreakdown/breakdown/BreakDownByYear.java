package com.vintrace.winebreakdown.breakdown;

import com.vintrace.winebreakdown.*;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BreakDownByYear implements BreakDownStrategy {
    @Override
    public BreakDownType getType() {
        return BreakDownType.YEAR;
    }

    @Override
    public BreakDownDTO convert(Wine wine) {
        List<BreakDownElementDTO> elements = wine.getComponents().stream()
                .sorted(Comparator.comparingDouble(WineComponent::getPercentage).reversed())
                .map(BreakDownByYear::convertToByYearElements)
                .collect(Collectors.toList());
        return new BreakDownDTO(getType(), elements);
    }

    private static BreakDownElementDTO convertToByYearElements(WineComponent component) {
        String percentage = DecimalFormat.getNumberInstance().format(component.getPercentage());
        return new BreakDownElementDTO(percentage, component.getYear().toString());
    }
}
