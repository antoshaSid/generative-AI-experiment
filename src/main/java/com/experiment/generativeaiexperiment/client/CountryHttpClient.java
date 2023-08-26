package com.experiment.generativeaiexperiment.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public final class CountryHttpClient {

    public static final String COUNTRY_URL = "https://restcountries.com/v3.1";

    private final HttpClient httpClient;

    private CountryHttpClient() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public String getAllCountries() throws IllegalArgumentException {
        try {
            final URI uri = new URI(COUNTRY_URL + "/all");
            final HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

            final HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (final Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static CountryHttpClient getInstance() {
        return new CountryHttpClient();
    }
}
