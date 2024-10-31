package com.koreait.weatherinfo_jby.controller;

import com.koreait.weatherinfo_jby.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    // 메인 조회 폼 페이지
    @GetMapping("/weather")
    public String showWeatherForm() {
        return "weather/form";  // 변경된 뷰 경로
    }

    // 조회 결과 페이지
    @GetMapping("/weather/result")
    public String getWeather(@RequestParam String city, Model model) {
        Map<String, Object> weatherData = weatherService.getWeather(city);
        model.addAttribute("city", city);
        model.addAttribute("weatherData", weatherData);
        return "weather/form";  // 결과도 동일한 뷰에서 표시
    }
}