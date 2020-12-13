package com.vintrace.winebreakdown.wine;

import com.vintrace.winebreakdown.wine.Wine;

import java.util.Optional;

public interface WineRepository {
    Optional<Wine> getByLotCode(String lotCode);
}
