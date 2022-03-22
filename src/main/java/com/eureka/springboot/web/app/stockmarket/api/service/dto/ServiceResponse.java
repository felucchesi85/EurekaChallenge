package com.eureka.springboot.web.app.stockmarket.api.service.dto;

import lombok.Data;


@Data
public class ServiceResponse {
	
    private String openPrice;
    private String higherPrice;
    private String lowerPrice;
    private String twoDayVariation;

}
