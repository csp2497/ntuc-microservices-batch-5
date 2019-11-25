package com.example.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrderControler {

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping("/orders/{orderId}")
    public String getOrder(@PathVariable String orderId){
        return orderId;
    }

    @PostMapping("/orders")
    public String createOrder(){
        restTemplate.getForObject("http://localhost:8081/items", List.class);
        return "order-1";
    }
}
