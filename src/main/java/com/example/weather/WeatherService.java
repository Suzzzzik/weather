package com.example.weather;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final RestTemplate restTemplate = new RestTemplate();
    private static final Gson gson = new Gson();

    public static WeatherResponse getWeather(String city) {
        String apiKey = "045c37b4f2654c01b4a161557241510";
        String url = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city;
        String response = restTemplate.getForObject(url, String.class);

        return gson.fromJson(response, WeatherResponse.class);
    }
}