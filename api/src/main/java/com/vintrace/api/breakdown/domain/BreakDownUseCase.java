package com.vintrace.api.breakdown.domain;

import com.vintrace.api.breakdown.domain.models.BreakDown;
import com.vintrace.api.breakdown.domain.models.BreakDownType;
import com.vintrace.api.breakdown.domain.strategies.BreakDownStrategy;
import com.vintrace.api.wine.domain.Wine;
import com.vintrace.api.wine.domain.WineRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BreakDownUseCase {

    private final WineRepository repository;
    private final List<BreakDownStrategy> strategies;

    public BreakDownUseCase(WineRepository repository, List<BreakDownStrategy> strategies) {
        this.repository = repository;
        this.strategies = strategies;
    }

    public BreakDown breakDown(String lotCode, BreakDownType breakdownType) {
        BreakDownStrategy strategy = strategies.stream()
                .filter(s -> s.getType() == breakdownType)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "breakdown type " + breakdownType + " is not supported"));
        Wine wine = repository.getByLotCode(lotCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "breakdown not available for " + lotCode));
        return strategy.convert(wine);
    }
}
