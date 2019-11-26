package com.example.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloWorldController {

    @Value("${greeting}")
    private String greeting;

    @GetMapping("/hello-world/{name}")
    public String hello(@PathVariable String name){
        return greeting + " "+ name + " !!";
    }
}
