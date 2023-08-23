package com.experiment.generativeaiexperiment.controller;

import com.experiment.generativeaiexperiment.service.CountryService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/country", produces = "application/json")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(final CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    public ResponseEntity<JsonNode> getAllCountries(@RequestParam(name = "name", required = false) final String name,
                                                    @RequestParam(name = "common", required = false) final String common,
                                                    @RequestParam(name = "population", required = false) final Integer population,
                                                    @RequestParam(name = "sort", required = false) final String sort) {
        final JsonNode json = countryService.getAllCountries();
        return ResponseEntity.ok(json);
    }
}
