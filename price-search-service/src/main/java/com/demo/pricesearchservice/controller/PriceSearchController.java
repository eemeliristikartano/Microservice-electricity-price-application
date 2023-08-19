package com.demo.pricesearchservice.controller;

import com.demo.pricesearchservice.service.PriceSearchService;
import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceSearchController {

    @Autowired
    PriceSearchService priceSearchService;

    @GetMapping("/getPrice")
    @CrossOrigin
    public ResponseEntity getPrice(@RequestParam String date, @RequestParam String hour) {
        if (date.isBlank() || hour.isBlank()) return new ResponseEntity("Date or hour cannot be null", HttpStatusCode.valueOf(HttpStatus.SC_BAD_REQUEST));
        return priceSearchService.getPrice(date,hour);
    }




}
