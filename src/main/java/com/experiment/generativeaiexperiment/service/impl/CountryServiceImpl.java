package com.experiment.generativeaiexperiment.service.impl;

import com.experiment.generativeaiexperiment.client.CountryHttpClient;
import com.experiment.generativeaiexperiment.service.CountryService;
import com.experiment.generativeaiexperiment.utils.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    @Override
    public JsonNode getAllCountries() {
        try {
            final CountryHttpClient client = CountryHttpClient.getInstance();
            return JsonParser.fromJson(client.getAllCountries());
        } catch (final JsonProcessingException e) {
            return null;
        }
    }
}
