package com.example.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("upload/v.1/test")
public class TestController {

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public String index() {
        System.out.println("Hello world end-point");
        return "Hello World";
    }
}
