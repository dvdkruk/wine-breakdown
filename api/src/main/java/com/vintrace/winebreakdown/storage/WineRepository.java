package com.vintrace.winebreakdown.storage;

import com.vintrace.winebreakdown.storage.model.Wine;

import java.util.Optional;

public interface WineRepository {
    Optional<Wine> getByLotCode(String lotCode);
}
