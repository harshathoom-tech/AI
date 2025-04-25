package com.demo.controller;

import com.demo.model.TestData;
import com.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private TestService testService;
    private final WebClient webClient = WebClient.create();


    @PostMapping("/update-test")
    public Mono<String> updateTest(@RequestBody TestData testData) {
        return testService.processTestData(testData)
                .map(result -> "Processed: " + result);
    }

     @GetMapping("/weather")
    public Mono<String> getWeather(@RequestParam String city) {
        String apiKey = "your_api_key"; // Replace with your actual API key
        String weatherApiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

        return webClient.get()
                .uri(weatherApiUrl)
                .retrieve()
                .bodyToMono(String.class)
                .map(response -> "Weather data for " + city + ": " + response);
    }
}