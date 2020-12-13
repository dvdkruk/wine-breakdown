package com.vintrace.winebreakdown;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WineBreakdownController {

    private final WineRepository repository;

    public WineBreakdownController(WineRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/breakdown/year/{lotCode}")
    public BreakDownDTO breakdownByYear(@PathVariable String lotCode) {
        Wine wine = repository.getByLotCode(lotCode).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<BreakDownElementDTO> elements = wine.getComponents().stream()
                .sorted(Comparator.comparingDouble(WineComponent::getPercentage).reversed())
                .map(WineBreakdownController::convertToByYearElements)
                .collect(Collectors.toList());
        return new BreakDownDTO(BreakDownType.YEAR, elements);
    }

    private static BreakDownElementDTO convertToByYearElements(WineComponent component) {
        String percentage = DecimalFormat.getNumberInstance().format(component.getPercentage());
        return new BreakDownElementDTO(percentage);
    }
}
