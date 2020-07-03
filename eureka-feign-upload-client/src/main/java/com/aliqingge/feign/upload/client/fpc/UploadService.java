package com.aliqingge.feign.upload.client.fpc;

import com.aliqingge.feign.upload.client.config.MultipartSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhangzhongqing@gogpay.cn
 * @date 2020/7/2 16:05
 */
@FeignClient(value = "eureka-feign-upload-server", configuration = MultipartSupportConfig.class, url = "http://10.10.10.13:8004")
public interface UploadService {

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String handleFileUpload(@RequestPart(value = "file") MultipartFile file);

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String fileUpload(@RequestPart(value = "file") MultipartFile file);

    /**
     * 测试
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    String test(@RequestParam(value = "name") String name);

}
