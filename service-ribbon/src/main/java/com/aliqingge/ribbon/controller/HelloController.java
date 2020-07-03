package com.aliqingge.ribbon.controller;

import com.aliqingge.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangzhongqing@gogpay.cn
 * @date 2020/7/2 10:45
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hi")
    private String hello(@RequestParam String name){
        return helloService.hiService(name);
    }

}
