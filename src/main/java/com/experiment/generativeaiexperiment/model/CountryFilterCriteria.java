package com.experiment.generativeaiexperiment.model;

public record CountryFilterCriteria(String name, Integer population, String sort) {

    public boolean filterByName() {
        return this.name != null && !this.name.isBlank();
    }

    public boolean filterByPopulation() {
        return this.population != null && this.population > 0;
    }

    public boolean sortByName() {
        return false;
    }
}
