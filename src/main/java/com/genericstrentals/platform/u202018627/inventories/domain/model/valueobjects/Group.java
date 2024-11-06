package com.genericstrentals.platform.u202018627.inventories.domain.model.valueobjects;

public enum Group {
    FORESTRY(1, "Forestry"),
    FARMING(2, "Farming"),
    LIVESTOCK(3, "Livestock"),;

    private final int id;
    private final String name;

    Group(int id, String name) {
        this.id = id;
        this.name = name;
    }
}