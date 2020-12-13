package com.vintrace.winebreakdown;

import com.vintrace.winebreakdown.breakdown.BreakDownService;
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

    private final BreakDownService service;

    public WineBreakdownController(BreakDownService service) {
        this.service = service;
    }

    @GetMapping("/api/breakdown/{breakdownType}/{lotCode}")
    public BreakDownDTO breakdownByYear(@PathVariable String lotCode, @PathVariable BreakDownType breakdownType) {
        return service.getBreakDown(lotCode, breakdownType);
    }
}
