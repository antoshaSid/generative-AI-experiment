package com.experiment.generativeaiexperiment.service.impl;

import com.experiment.generativeaiexperiment.client.CountryHttpClient;
import com.experiment.generativeaiexperiment.model.CountryFilterCriteria;
import com.experiment.generativeaiexperiment.service.CountryService;
import com.experiment.generativeaiexperiment.utils.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryHttpClient countryHttpClient;

    public CountryServiceImpl() {
        this.countryHttpClient = CountryHttpClient.getInstance();
    }

    @Override
    public List<JsonNode> getAllCountries(final CountryFilterCriteria filterCriteria) {
        List<JsonNode> nodeList = new ArrayList<>();

        try {
            final JsonNode jsonNode = JsonParser.fromJson(countryHttpClient.getAllCountries());

            if (jsonNode.isArray()) {
                jsonNode.elements().forEachRemaining(nodeList::add);
            }
        } catch (final JsonProcessingException ignore) {
            // ignore exception
        }

        if (!nodeList.isEmpty()) {
            if (filterCriteria.filterByName()) {
                nodeList = this.filterByName(filterCriteria.name(), nodeList);
            }

//            if (filterCriteria.filterByPopulation()) {
//
//            }

//            if (sort) {
//
//            }
        }

        return nodeList;
    }

    private List<JsonNode> filterByName(final String name, final List<JsonNode> countryList) {
        return countryList.stream()
            .filter(countryNode -> countryNode.get("name")
                .get("common")
                .textValue()
                .toLowerCase()
                .contains(name.toLowerCase()))
            .collect(Collectors.toList());
    }
}
