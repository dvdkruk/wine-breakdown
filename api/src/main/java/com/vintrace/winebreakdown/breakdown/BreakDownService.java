package com.vintrace.winebreakdown.breakdown;

import com.vintrace.winebreakdown.breakdown.model.BreakDown;
import com.vintrace.winebreakdown.breakdown.model.BreakDownType;
import com.vintrace.winebreakdown.breakdown.strategies.BreakDownStrategy;
import com.vintrace.winebreakdown.storage.model.Wine;
import com.vintrace.winebreakdown.storage.WineRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BreakDownService {

    private final WineRepository repository;
    private final List<BreakDownStrategy> strategies;

    public BreakDownService(WineRepository repository, List<BreakDownStrategy> strategies) {
        this.repository = repository;
        this.strategies = strategies;
    }

    public BreakDown getBreakDown(String lotCode, BreakDownType breakdownType) {
        BreakDownStrategy strategy = strategies.stream()
                .filter(s -> s.getType() == breakdownType)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "breakdown type " + breakdownType + " is not supported"));
        Wine wine = repository.getByLotCode(lotCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "breakdown not available for " + lotCode));
        return strategy.convert(wine);
    }
}
