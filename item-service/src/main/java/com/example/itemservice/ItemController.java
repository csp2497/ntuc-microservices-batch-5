package com.example.itemservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@Slf4j
public class ItemController {

    @Value("${server.port}")
    private String port;
    private int errorCounter = 0;


    @GetMapping("/items")
    public List<String> getItems() throws InterruptedException {
        log.info("getItem is invoked....");
        Random random = new Random();
        int low = 100;
        int high = 1000;
        int result = random.nextInt(high - low) + low;
        Thread.sleep(result);
        errorCounter++;
        if(errorCounter%2==0){
            log.error("Exception occurred in time service!!!!");
            new RuntimeException("Exception occurred in time service!!!!");
        }
        log.info("getItem invocation is complete.");
        return Arrays.asList("iphone", "samsung", "nokia", port);
    }
}