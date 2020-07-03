package com.aliqingge.feign.controller;

import com.aliqingge.feign.client.HelloServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangzhongqing@gogpay.cn
 * @date 2020/7/2 11:42
 */
@RestController
public class HelloServiceController {

    @Autowired
    private HelloServiceFeign helloServiceFeign;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        return helloServiceFeign.sayHiFromClientOne(name);
    }

}
