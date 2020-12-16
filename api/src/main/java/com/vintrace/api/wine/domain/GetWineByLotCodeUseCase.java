package com.vintrace.api.wine.domain;

import com.vintrace.api.wine.domain.models.Wine;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetWineByLotCodeUseCase {

    private final WineRepository repository;

    public GetWineByLotCodeUseCase(WineRepository repository) {
        this.repository = repository;
    }

    public Optional<Wine> get(String lotCode) {
        return repository.getByLotCode(lotCode);
    }
}
