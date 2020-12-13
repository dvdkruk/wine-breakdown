package com.vintrace.winebreakdown.config;

import com.vintrace.winebreakdown.breakdown.model.BreakDownType;
import org.springframework.core.convert.converter.Converter;

public class BreakDownTypeToEnumConverter implements Converter<String, BreakDownType> {
    @Override
    public BreakDownType convert(String source) {
        return BreakDownType.valueOf(source.toUpperCase().replace('-', '_'));
    }
}
