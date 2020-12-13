package com.vintrace.winebreakdown;

import java.util.List;

public class Wine {

    private final String lotCode;

    public Wine(String lotCode, List<WineComponent> components) {
        this.lotCode = lotCode;
    }
}
