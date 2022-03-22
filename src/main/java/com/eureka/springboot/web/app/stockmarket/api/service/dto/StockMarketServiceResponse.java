package com.eureka.springboot.web.app.stockmarket.api.service.dto;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Repository
public class StockMarketServiceResponse {
	
	@JsonProperty("Meta Data")
    private MetaData metaData;

    @JsonProperty("Time Series (Daily)")
    private Map<String, TimeSeriesDaily> timeSeriesDaily;


}
