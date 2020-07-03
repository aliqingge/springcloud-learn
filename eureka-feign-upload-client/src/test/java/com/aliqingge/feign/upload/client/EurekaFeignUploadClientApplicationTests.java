package com.aliqingge.feign.upload.client;

import com.aliqingge.feign.upload.client.fpc.UploadService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class EurekaFeignUploadClientApplicationTests {

    @Autowired
    private UploadService uploadService;

    @Test
    @SneakyThrows
    void contextLoads() {

        File file = new File("upload.txt");
        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file",
                MediaType.MULTIPART_FORM_DATA_VALUE, true, file.getName());

        try (FileInputStream input = new FileInputStream(file); OutputStream os = fileItem.getOutputStream()) {
            IOUtils.copy(input, os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }

        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
        String desc = uploadService.fileUpload(multipartFile);
        log.info("desc:{}", desc);

    }

}
