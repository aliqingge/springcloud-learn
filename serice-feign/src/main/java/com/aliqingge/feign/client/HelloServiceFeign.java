package com.aliqingge.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhangzhongqing@gogpay.cn
 * @date 2020/7/2 11:39
 */
@FeignClient(value = "eureka-client")
public interface HelloServiceFeign {

    /**
     * 测试
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
