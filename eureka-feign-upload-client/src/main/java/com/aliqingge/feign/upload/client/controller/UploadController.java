package com.aliqingge.feign.upload.client.controller;

import com.aliqingge.feign.upload.client.fpc.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Administrator
 * @date 2020/7/2 16:07
 */
@RestController
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart(value = "file") MultipartFile file) {
        return uploadService.fileUpload(file);
    }

    @PostMapping(value = "/test")
    public String test(@RequestParam(value = "name") String name) {
        return uploadService.test(name);
    }

}
