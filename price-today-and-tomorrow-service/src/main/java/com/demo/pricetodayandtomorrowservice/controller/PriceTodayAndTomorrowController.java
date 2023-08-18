package com.demo.pricetodayandtomorrowservice.controller;

import com.demo.pricetodayandtomorrowservice.service.PriceTodayAndTomorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceTodayAndTomorrowController {

    @Autowired
    PriceTodayAndTomorrowService priceTodayAndTomorrowService;

    @GetMapping("/TodayAndDayForward")
    public ResponseEntity getTodayAndDayForwardPrices() {
        return priceTodayAndTomorrowService.priceTodayAndTomorrow();
    }

}
