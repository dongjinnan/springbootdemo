package com.example.demo.service;

import java.util.Map;

/**
 * @author Jane Dong
 * @description: first spring boot service
 * @date Created in 2021/1/1 14:49.
 */
public interface DemoService {
    // 获取城市天气信息
    Map<String, String> getWeather(String city);
}
