package com.eureka.springboot.web.app.stockmarket.service;

import com.eureka.springboot.web.app.stockmarket.api.service.dto.ServiceResponse;
import com.eureka.springboot.web.app.stockmarket.entities.User;

public interface StockMarketService {
	
	User signUpUser(String firstName, String lastName, String email) throws Exception;
	
	ServiceResponse getStockData(String symbol) throws Exception; 

}
