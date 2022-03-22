package com.eureka.springboot.web.app.stockmarket.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.springboot.web.app.stockmarket.api.service.dto.ServiceResponse;
import com.eureka.springboot.web.app.stockmarket.entities.User;
import com.eureka.springboot.web.app.stockmarket.model.request.UserRequestSingUpModel;
import com.eureka.springboot.web.app.stockmarket.service.StockMarketService;


@RestController
@RequestMapping("/stockmarket")
@Validated
public class StockMarketController {
	
	private final Logger logger = LoggerFactory.getLogger(StockMarketController.class);
	
	@Autowired
	private StockMarketService stockMarketService;

    @PostMapping("/users/signup")
    public User signUpUser(HttpServletRequest requestToCache, @RequestBody UserRequestSingUpModel userRequestSingUpModel) throws Exception {
    	logger.info("StockMarketController::signUpUser() method call...".concat(requestToCache.getMethod()).concat("/users/signup"));
        return stockMarketService.signUpUser(userRequestSingUpModel.getFirstName(), userRequestSingUpModel.getLastName(), userRequestSingUpModel.getEmail());
    }

    
    @GetMapping("/stocks")
    public ServiceResponse stockData(HttpServletRequest requestToCache, @RequestParam("symbol") String symbol) throws Exception {
    	logger.info("StockMarketController::signUpUser() method call...".concat(requestToCache.getMethod()).concat("/stocks"));
        return stockMarketService.getStockData(symbol);
    }

}
