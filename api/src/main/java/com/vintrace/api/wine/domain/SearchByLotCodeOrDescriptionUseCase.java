package com.vintrace.api.wine.domain;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchByLotCodeOrDescriptionUseCase {

    private final WineRepository repository;

    public SearchByLotCodeOrDescriptionUseCase(WineRepository repository) {
        this.repository = repository;
    }

    public List<Wine> search(String query) {
        return repository.findByLotCodeContainingOrDescriptionContaining(query);
    }
}
