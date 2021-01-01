package com.example.demo;

import com.example.demo.service.DemoService;
import com.example.demo.service.impl.DemoServiceImpl;
import org.junit.Assert;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class DemoServiceTest {

    @Autowired
    private DemoService demoService;

    @Test
    public void getWeather() {
        demoService = new DemoServiceImpl();
        Map<String, String> dalianMap = demoService.getWeather("Dalian");
        Assert.assertThat(dalianMap.get("message"), is("success"));

        Map<String, String> errorMap = demoService.getWeather("aaa");
        Assert.assertThat(errorMap.get("message"), is("City Not Found!"));
    }
}
