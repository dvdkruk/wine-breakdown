package com.vintrace.api.wine.domain;

import com.vintrace.api.wine.domain.Wine;

import java.util.Optional;

public interface WineRepository {
    Optional<Wine> getByLotCode(String lotCode);
}
