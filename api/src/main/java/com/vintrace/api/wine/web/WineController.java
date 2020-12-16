package com.vintrace.api.wine.web;

import com.vintrace.api.wine.domain.GetWineByLotCodeUseCase;
import com.vintrace.api.wine.domain.SearchByLotCodeOrDescriptionUseCase;
import com.vintrace.api.wine.domain.models.Wine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
class WineController {

    private final SearchByLotCodeOrDescriptionUseCase searchByLotCodeOrDescriptionUseCase;
    private final GetWineByLotCodeUseCase getWineByLotCodeUseCase;

    public WineController(
            SearchByLotCodeOrDescriptionUseCase searchByLotCodeOrDescriptionUseCase,
            GetWineByLotCodeUseCase getWineByLotCodeUseCase
    ){
        this.searchByLotCodeOrDescriptionUseCase = searchByLotCodeOrDescriptionUseCase;
        this.getWineByLotCodeUseCase = getWineByLotCodeUseCase;
    }

    @GetMapping("/api/wines")
    public WinesSearchResponse searchWines(@RequestParam("search") String query) {
        List<Wine> wines = searchByLotCodeOrDescriptionUseCase.search(query);
        return new WinesSearchResponse(wines);
    }

    @GetMapping("/api/wines/{lotCode}")
    public Optional<Wine> getWine(@PathVariable String lotCode) {
        return getWineByLotCodeUseCase.get(lotCode);
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
