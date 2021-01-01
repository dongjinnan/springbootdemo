package com.example.demo.service.impl;

import com.example.demo.service.DemoService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public Map<String, String> getWeather(String city) {
        Map<String, String> resultMap = new HashMap<String, String>();
        String url="http://api.openweathermap.org/data/2.5/weather?q=" + city + "&mode=json&units=metric&lang=zh_cn&APPID=6a67ed641c0fda8b69715c43518b6996";

        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
            String json = results.getBody();
            resultMap.put("data", json);
            resultMap.put("message", "success");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("message", "City Not Found!");
        }
        return resultMap;
    }
}
