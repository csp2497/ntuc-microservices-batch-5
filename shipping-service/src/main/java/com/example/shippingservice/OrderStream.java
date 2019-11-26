package com.example.shippingservice;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface OrderStream {

    String ORDER_INPUT_STREAM = "order-input-stream";

    @Input(ORDER_INPUT_STREAM)
    SubscribableChannel inboudOrderStreamChannel();
}