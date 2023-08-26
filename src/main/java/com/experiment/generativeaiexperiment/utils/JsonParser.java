package com.experiment.generativeaiexperiment.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonParser {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private JsonParser() {
    }

    public static String toJson(final Object value) throws JsonProcessingException {
        return MAPPER.writeValueAsString(value);
    }

    public static JsonNode fromJson(final String json) throws JsonProcessingException {
        return MAPPER.readTree(json);
    }
}
