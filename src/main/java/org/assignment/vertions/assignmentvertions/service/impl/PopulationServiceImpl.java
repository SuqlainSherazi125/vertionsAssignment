package org.assignment.vertions.assignmentvertions.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.assignment.vertions.assignmentvertions.service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class PopulationServiceImpl implements PopulationService {
    private static String rapidAPIHost="get-population.p.rapidapi.com";
    private static String rapidAPIKey="935be488f3mshc589afbf5723511p1f95dfjsn5df5ff38f72f";
    private static String URL = "https://get-population.p.rapidapi.com/population/country?country=";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Object getPopulation(String country) {
        ResponseEntity<String> response = null;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("X-RapidAPI-Key", rapidAPIKey);
            headers.add("X-RapidAPI-Host", rapidAPIHost);
            response = restTemplate.exchange(URL + country, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        } catch (Exception e) {
            log.error("error while fetching population data for country: "+ country, e);
        }
        return response.getBody();
    }

//    public Object getPopulation(String country) {
//
//    }
}
