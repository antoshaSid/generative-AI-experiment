package com.experiment.generativeaiexperiment.service;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

public interface CountryService {

    List<JsonNode> getAllCountries();
}
