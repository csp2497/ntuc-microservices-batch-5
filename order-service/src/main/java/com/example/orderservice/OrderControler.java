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
    public List createOrder(){
        List list = restTemplate.getForObject("http://ITEM-SERVICE/items", List.class);
        System.out.println(list);
        return list;
    }
}
