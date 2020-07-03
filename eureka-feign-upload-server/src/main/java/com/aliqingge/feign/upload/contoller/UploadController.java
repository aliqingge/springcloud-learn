package com.aliqingge.feign.upload.contoller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Administrator
 * @date 2020/7/2 15:52
 */
@RestController
public class UploadController {

    @PostMapping(value = "/uploadFile")
    public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
        System.out.println("收到请求的文件名称：" + file.getOriginalFilename());
        return file.getName();
    }

    @PostMapping(value = "/upload")
    public String fileUpload(@RequestPart(value = "file") MultipartFile file) {
        System.out.println("收到请求的文件名称：" + file.getOriginalFilename());
        return file.getOriginalFilename();
    }

    @PostMapping(value = "/test")
    public String test(@RequestParam(value = "name") String name) {
        System.out.println("收到请求的名称：" + name);
        return name;
    }
}
