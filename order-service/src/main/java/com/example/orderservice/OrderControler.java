package com.example.orderservice;

import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
public class OrderControler {

    @Autowired
    public RestTemplate restTemplate;


    @Autowired
    private Source source;

    private int orderNumber = 100;

    @GetMapping("/orders")
    public String getOrder(){
        try {
            restTemplate.getForObject("http://ITEM-SERVICE/items", List.class);
        }catch (Exception e){
            log.error("Error occurred while calling the item service", e);
        }
        return "orderid-1";
    }

    @PostMapping("/orders")
    public List createOrder(){
        List list = restTemplate.getForObject("http://ITEM-SERVICE/items", List.class);
        System.out.println(list);
        source.output().send(MessageBuilder.withPayload( "Order-" + ++orderNumber).build());
        return list;
    }
}
