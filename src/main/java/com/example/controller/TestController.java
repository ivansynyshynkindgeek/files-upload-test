package com.example.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Controller("upload/v.1/test")
@Secured(SecurityRule.IS_ANONYMOUS)
public class TestController {

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public String index() {
        System.out.println("Hello world end-point");
        return "Hello World";
    }
}
