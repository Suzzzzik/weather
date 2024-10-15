package com.example.weather;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("city") String city, Model model) {
        WeatherResponse weatherData = WeatherService.getWeather(city);
        if (weatherData != null) {
            model.addAttribute("city", city);
            model.addAttribute("temperature", weatherData.getCurrent().getTemp_c());
            model.addAttribute("feelsLike", weatherData.getCurrent().getFeelslike_c());
            model.addAttribute("humidity", weatherData.getCurrent().getHumidity());
            model.addAttribute("windSpeed", weatherData.getCurrent().getWind_kph());
            model.addAttribute("conditionText", weatherData.getCurrent().getCondition().getText());
            model.addAttribute("conditionIcon", "http:" + weatherData.getCurrent().getCondition().getIcon());
        }
        return "index";
    }
}