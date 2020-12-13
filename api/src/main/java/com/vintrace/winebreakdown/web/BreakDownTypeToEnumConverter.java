package com.vintrace.winebreakdown.web;

import com.vintrace.winebreakdown.BreakDownType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.GenericConverter;

public class BreakDownTypeToEnumConverter implements Converter<String, BreakDownType> {
    @Override
    public BreakDownType convert(String source) {
        return BreakDownType.valueOf(source.toUpperCase());
    }
}
