package com.aliqingge.eureka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Administrator
 */
@RestController
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/hi")
    public String home(@RequestParam String name) throws InterruptedException {
//        Thread.sleep(5000L);
        List<String> services = discoveryClient.getServices();
        System.out.println("----注册中心的服务信息：" + services);
        return "hi " + name + ",i am from port:" + port;
    }

}
