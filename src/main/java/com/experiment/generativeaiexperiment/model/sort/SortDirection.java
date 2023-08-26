package com.experiment.generativeaiexperiment.model.sort;

import java.util.Arrays;

public enum SortDirection {

    ASC("ascend"),
    DESC("descend");

    SortDirection(final String direction) {
        this.direction = direction;
    }

    private final String direction;

    public static SortDirection getDirection(final String direction) {
        return Arrays.stream(values())
            .filter(d -> d.direction.equalsIgnoreCase(direction))
            .findFirst()
            .orElse(null);
    }
}
