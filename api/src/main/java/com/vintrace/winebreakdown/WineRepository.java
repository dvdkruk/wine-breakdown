package com.vintrace.winebreakdown;

import java.util.Optional;

interface WineRepository {
    Optional<Wine> getByLotCode(String lotCode);
}
