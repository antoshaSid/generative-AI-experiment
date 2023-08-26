package com.experiment.generativeaiexperiment.service.impl;

import com.experiment.generativeaiexperiment.client.CountryHttpClient;
import com.experiment.generativeaiexperiment.service.CountryService;
import com.experiment.generativeaiexperiment.utils.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryHttpClient countryHttpClient;

    public CountryServiceImpl() {
        this.countryHttpClient = CountryHttpClient.getInstance();
    }

    @Override
    public List<JsonNode> getAllCountries() {
        final ArrayList<JsonNode> nodeList = new ArrayList<>();

        try {
            final JsonNode jsonNode = JsonParser.fromJson(countryHttpClient.getAllCountries());

            if (jsonNode.isArray()) {
                jsonNode.elements().forEachRemaining(nodeList::add);
            }
        } catch (final JsonProcessingException ignore) {
            // ignore exception
        }

        return nodeList;
    }
}
