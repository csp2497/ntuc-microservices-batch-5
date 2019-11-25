package com.example.orderservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControler {

    @GetMapping("/orders/{orderId}")
    public String getOrder(@PathVariable String orderId){
        return orderId;
    }
}
