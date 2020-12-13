package com.vintrace.winebreakdown.breakdown;

import com.vintrace.winebreakdown.breakdown.model.BreakDown;
import com.vintrace.winebreakdown.breakdown.model.BreakDownType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class WineBreakdownController {

    private final BreakDownService service;

    public WineBreakdownController(BreakDownService service) {
        this.service = service;
    }

    @GetMapping("/api/breakdown/{breakdownType}/{lotCode}")
    public BreakDown breakdownByYear(@PathVariable String lotCode, @PathVariable BreakDownType breakdownType) {
        return service.getBreakDown(lotCode, breakdownType);
    }
}
