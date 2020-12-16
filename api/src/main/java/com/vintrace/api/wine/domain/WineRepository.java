package com.vintrace.api.wine.domain;

import com.vintrace.api.wine.domain.models.Wine;

import java.util.List;
import java.util.Optional;

public interface WineRepository {
    Optional<Wine> getByLotCode(String lotCode);

    List<Wine> findByLotCodeContainingOrDescriptionContaining(String query);
}
