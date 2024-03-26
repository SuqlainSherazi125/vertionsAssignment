package org.assignment.vertions.assignmentvertions.service;

import org.assignment.vertions.assignmentvertions.service.CountryService;

public interface WeatherService extends CountryService {
    Object getWeatherInfo(String country);
}
