package com.experiment.generativeaiexperiment.service.impl;

import com.experiment.generativeaiexperiment.model.CountryFilterCriteria;
import com.experiment.generativeaiexperiment.model.sort.SortDirection;
import com.experiment.generativeaiexperiment.service.CountryService;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

class CountryServiceImplTest {

    private final CountryService underTest;

    public CountryServiceImplTest() {
        this.underTest = new CountryServiceImpl();
    }

    @Test
    void getAllCountries__filter_by_name() {
        final String filterByName = "sT";
        final CountryFilterCriteria filterCriteria = new CountryFilterCriteria(filterByName, null, null, null);

        final List<JsonNode> resultList = underTest.getAllCountries(filterCriteria);

        resultList.forEach(node -> {
            final String countryName = node.get("name").get("common").textValue();
            assertThat(countryName, containsStringIgnoringCase(filterByName));
        });
        assertThat(resultList, hasSize(21));
    }

    @Test
    void getAllCountries__filter_by_population() {
        final int filterByPopulation = 12;
        final CountryFilterCriteria filterCriteria = new CountryFilterCriteria(null, filterByPopulation, null, null);

        final List<JsonNode> resultList = underTest.getAllCountries(filterCriteria);

        resultList.forEach(node -> {
            final Long countryPopulation = node.get("population").longValue();
            assertThat(countryPopulation, lessThan(filterByPopulation * 1000000L));
        });
        assertThat(resultList, hasSize(173));
    }

    @Test
    void getAllCountries__sort_by_name_desc() {
        final SortDirection direction = SortDirection.DESC;
        final CountryFilterCriteria filterCriteria = new CountryFilterCriteria(null, null, direction, 15);

        final List<JsonNode> resultList = underTest.getAllCountries(filterCriteria);

        assertIsSorted(resultList, direction);
        assertThat(resultList, hasSize(15));
    }

    @Test
    void getAllCountries__sort_by_name_asc() {
        final SortDirection direction = SortDirection.ASC;
        final CountryFilterCriteria filterCriteria = new CountryFilterCriteria(null, null, direction, 25);

        final List<JsonNode> resultList = underTest.getAllCountries(filterCriteria);

        assertIsSorted(resultList, direction);
        assertThat(resultList, hasSize(25));
    }

    @Test
    void getAllCountries__set_limit_5() {
        final CountryFilterCriteria filterCriteria = new CountryFilterCriteria(null, null, null, 5);

        final List<JsonNode> resultList = underTest.getAllCountries(filterCriteria);

        assertThat(resultList, hasSize(5));
    }

    @Test
    void getAllCountries__filter_by_name_population_and_sort_by_name_desc() {
        final String filterByName = "lAnD";
        final int filterByPopulation = 15;
        final SortDirection direction = SortDirection.DESC;
        final CountryFilterCriteria filterCriteria = new CountryFilterCriteria(filterByName, filterByPopulation, direction, null);

        final List<JsonNode> resultList = underTest.getAllCountries(filterCriteria);

        resultList.forEach(node -> {
            final String countryName = node.get("name").get("common").textValue();
            assertThat(countryName, containsStringIgnoringCase(filterByName));

            final Long countryPopulation = node.get("population").longValue();
            assertThat(countryPopulation, lessThan(filterByPopulation * 1000000L));
        });
        assertIsSorted(resultList, direction);
        assertThat(resultList, hasSize(26));
    }

    private void assertIsSorted(final List<JsonNode> list, final SortDirection direction) {
        final List<String> countryNames = list.stream()
            .map(node -> node.get("name").get("common").textValue())
            .toList();

        String previousName = countryNames.get(0);
        boolean result = true;
        int compared;

        for (int i = 1; i < countryNames.size(); i++) {
            String nextName = countryNames.get(i);

            if (direction == SortDirection.DESC) {
                compared = String.CASE_INSENSITIVE_ORDER.compare(previousName, nextName);
            } else {
                compared = String.CASE_INSENSITIVE_ORDER.reversed().compare(previousName, nextName);
            }
            result &= compared >= 0;
            previousName = nextName;
        }

        assertThat(result, is(true));
    }
}
