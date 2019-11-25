package com.example.itemservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ItemController {

    @GetMapping("/items")
    public List<String> getItems(){
        System.out.println("Calling the item service...");
        return Arrays.asList("iPhone", "Samsung", "Nokia");
    }
}
