package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jane Dong
 * @description: first spring boot controller
 * @date Created in 2021/1/1 10:49.
 */
@Controller
public class DemoController {

    @Value("${city}")
    private String city;

    @Autowired
    private DemoService demoService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @ResponseBody
    @GetMapping("/city")
    public Map<String, String> find() {
        Map<String, String> result = new HashMap<String, String>();
        result.put("data", city);
        return result;
    }

    @ResponseBody
    @GetMapping("/weather")
    public Map<String, String> search(HttpServletRequest request) {
        String city = request.getParameter("city");
        Map<String, String> result = demoService.getWeather(city);
        return result;
    }
}