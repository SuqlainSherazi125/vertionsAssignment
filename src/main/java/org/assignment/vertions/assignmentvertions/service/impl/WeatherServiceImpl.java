package org.assignment.vertions.assignmentvertions.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.assignment.vertions.assignmentvertions.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {
    private static String weatherAPIHost="visual-crossing-weather.p.rapidapi.com";
    private static String weatherAPIKey="935be488f3mshc589afbf5723511p1f95dfjsn5df5ff38f72f";
    private static String URL = "https://visual-crossing-weather.p.rapidapi.com/forecast?aggregateHours=24&location=";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Object getWeatherInfo(String country) {
        ResponseEntity<String> response = null;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("X-RapidAPI-Key", weatherAPIKey);
            headers.add("X-RapidAPI-Host", weatherAPIHost);
            response = restTemplate.exchange(URL+country+"&contentType=csv&unitGroup=us&shortColumnNames=0",
                    HttpMethod.GET, new HttpEntity<>(headers), String.class);
            log.info("resp: "+response.getBody());
        } catch (Exception e) {
            log.error("error while fetching corona data: ", e);
        }
        return response.getBody();
    }
}
