package org.assignment.vertions.assignmentvertions.controller;
import org.assignment.vertions.assignmentvertions.service.PopulationService;
import org.assignment.vertions.assignmentvertions.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.invoke.MethodType;

@Controller
public class RESTController {

    @Autowired
    PopulationService populationService;
    @Autowired
    WeatherService weatherService;

    @GetMapping("/home")
    public String main() {
        return "index";
    }

    @RequestMapping(value = "/populationData")
    public ResponseEntity<?> getPopulation(
            @RequestParam(value = "country", required = false) String country) {
        return ResponseEntity.ok(populationService.getPopulation(country));
    }

    @RequestMapping("/weatherData")
    public ResponseEntity<?> getWeatherDetails(@RequestParam(value = "country", required = false) String country) {
        return ResponseEntity.ok(weatherService.getWeatherInfo(country));
    }
}
