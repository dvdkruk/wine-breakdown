package com.vintrace.winebreakdown.breakdown;

import com.vintrace.winebreakdown.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BreakDownService {

    private final WineRepository repository;
    private final List<BreakDownStrategy> strategies;

    public BreakDownService(WineRepository repository, List<BreakDownStrategy> strategies) {
        this.repository = repository;
        this.strategies = strategies;
    }

    public BreakDownDTO getBreakDown(String lotCode, BreakDownType breakdownType) {
        BreakDownStrategy strategy = strategies.stream()
                .filter(s -> s.getType() == breakdownType)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "breakdown type " + breakdownType + " is not supported"));
        Wine wine = repository.getByLotCode(lotCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return strategy.convert(wine);
    }
}
