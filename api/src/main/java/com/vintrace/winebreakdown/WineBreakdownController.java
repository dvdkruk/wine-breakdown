package com.vintrace.winebreakdown;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WineBreakdownController {

    @GetMapping("/api/breakdown/year/{lotCode}")
    public BreakDownDTO breakdownByYear(@PathVariable String lotCode) {
        return new BreakDownDTO(BreakDownType.YEAR);
    }
}
