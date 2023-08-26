package com.experiment.generativeaiexperiment.model.sort;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Comparator;

public class CountryComparator implements Comparator<JsonNode> {

    private final SortDirection direction;

    public CountryComparator(SortDirection direction) {
        this.direction = direction;
    }

    @Override
    public int compare(final JsonNode n1, final JsonNode n2) {
        final String firstCountryName = n1.get("name")
            .get("common")
            .textValue();
        final String secondCountryName = n2.get("name")
            .get("common")
            .textValue();

        return direction == SortDirection.ASC ?
            String.CASE_INSENSITIVE_ORDER.compare(firstCountryName, secondCountryName) :
            String.CASE_INSENSITIVE_ORDER.reversed().compare(firstCountryName, secondCountryName);
    }
}
