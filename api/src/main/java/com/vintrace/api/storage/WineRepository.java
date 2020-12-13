package com.vintrace.api.storage;

import com.vintrace.api.storage.model.Wine;

import java.util.Optional;

public interface WineRepository {
    Optional<Wine> getByLotCode(String lotCode);
}
