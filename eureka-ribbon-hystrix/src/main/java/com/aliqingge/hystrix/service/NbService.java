package com.aliqingge.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 * @date 2020/7/3 11:35
 */
@Service
public class NbService {

    @Autowired
    private RestTemplate restTemplate;

//    @HystrixCommand(fallbackMethod = "fallback")
    @HystrixCommand
    public String getConsumer(String name) {
        return restTemplate.getForObject("http://eureka-client/hi?name=" + name, String.class);
    }

    public String fallback() {
        return "fallback";
    }

}
