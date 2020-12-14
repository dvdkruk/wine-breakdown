package com.vintrace.api.breakdown.web;

import com.vintrace.api.breakdown.domain.models.BreakDownType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class StringToBreakDownTypeConverter implements Converter<String, BreakDownType> {
    @Override
    public BreakDownType convert(String source) {
        return BreakDownType.valueOf(source.toUpperCase().replace('-', '_'));
    }
}
