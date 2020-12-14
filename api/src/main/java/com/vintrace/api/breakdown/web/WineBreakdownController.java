package com.vintrace.api.breakdown.web;

import com.vintrace.api.breakdown.domain.BreakDownUseCase;
import com.vintrace.api.breakdown.domain.models.BreakDown;
import com.vintrace.api.breakdown.domain.models.BreakDownType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class WineBreakdownController {

    private final BreakDownUseCase breakDownUseCase;

    public WineBreakdownController(BreakDownUseCase breakDownUseCase) {
        this.breakDownUseCase = breakDownUseCase;
    }

    @GetMapping("/api/breakdown/{breakdownType}/{lotCode}")
    public BreakDown breakdownByYear(@PathVariable String lotCode, @PathVariable BreakDownType breakdownType) {
        return breakDownUseCase.breakDown(lotCode, breakdownType);
    }
}
