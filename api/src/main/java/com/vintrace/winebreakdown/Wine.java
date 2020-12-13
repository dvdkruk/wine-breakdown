package com.vintrace.winebreakdown;

import java.util.List;

public class Wine {

    private final String lotCode;
    private final List<WineComponent> components;

    public Wine(String lotCode, List<WineComponent> components) {
        this.lotCode = lotCode;
        this.components = components;
    }

    public List<WineComponent> getComponents() {
        return components;
    }
}
