package com.experiment.generativeaiexperiment.model;

import com.experiment.generativeaiexperiment.model.sort.SortDirection;

public record CountryFilterCriteria(String name, Integer population, SortDirection direction) {

    public boolean filterByName() {
        return this.name != null && !this.name.isBlank();
    }

    public boolean filterByPopulation() {
        return this.population != null && this.population > 0;
    }

    public boolean sortByName() {
        return direction != null;
    }
}
