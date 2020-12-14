package com.vintrace.api.wine.web;

import com.vintrace.api.wine.domain.SearchByLotCodeOrDescriptionUseCase;
import com.vintrace.api.wine.domain.Wine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class WineController {

    private final SearchByLotCodeOrDescriptionUseCase searchByLotCodeOrDescriptionUseCase;

    public WineController(SearchByLotCodeOrDescriptionUseCase searchByLotCodeOrDescriptionUseCase){
        this.searchByLotCodeOrDescriptionUseCase = searchByLotCodeOrDescriptionUseCase;
    }

    @GetMapping("/api/wines")
    public WinesSearchResponse wines(@RequestParam("search") String search) {
        List<Wine> wines = searchByLotCodeOrDescriptionUseCase.search(search);
        return new WinesSearchResponse(wines);
    }

    static class WinesSearchResponse {
        private final List<Wine> wines;

        WinesSearchResponse(List<Wine> wines) {
            this.wines = wines;
        }

        public List<Wine> getWines() {
            return wines;
        }
    }
}
