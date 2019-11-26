package com.example.shippingservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderListener {

    @StreamListener(OrderStream.ORDER_INPUT_STREAM)
    public void getShipmentOrder(@Payload String orderId){
        log.info("getShipmentOrder is invoked");
        System.out.println("Received the order : " + orderId);
        log.info("getShipmentOrder invocation is complete");
    }
}
