package com.vintrace.winebreakdown;

import java.util.Optional;

public interface WineRepository {
    Optional<Wine> getByLotCode(String lotCode);
}
