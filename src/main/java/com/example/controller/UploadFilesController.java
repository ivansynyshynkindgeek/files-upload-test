package com.example.controller;

import com.example.service.S3Service;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Controller("upload/v.1")
@Secured(SecurityRule.IS_ANONYMOUS)
public class UploadFilesController {

    private final S3Service s3Service;

    public UploadFilesController(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @Post
    public HttpResponse<String> connectToS3() {
        this.s3Service.connectToS3();
        return HttpResponse.ok("Connected to S3");
    }
}
