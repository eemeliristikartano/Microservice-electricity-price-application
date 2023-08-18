package com.demo.pricetodayandtomorrowservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceTodayAndTomorrowController {

    @Value("${PRICE_TODAY_AND_TOMORROW_API}")
    String API;

    @GetMapping("/test")
    public void test() {
        System.out.println(API);
    }

}
