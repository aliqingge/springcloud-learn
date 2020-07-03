package com.aliqingge.hystrix.controller;

import com.aliqingge.hystrix.service.NbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2020/7/3 11:34
 */
@RestController
public class NbController {

    @Autowired
    private NbService nbService;

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name) {
        return nbService.getConsumer(name);
    }

}
