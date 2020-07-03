package com.aliqingge.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 使用@EnableCircuitBreaker或@EnableHystrix注解开启Hystrix的使用
 *
 * @author Administrator
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaRibbonHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaRibbonHystrixApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
