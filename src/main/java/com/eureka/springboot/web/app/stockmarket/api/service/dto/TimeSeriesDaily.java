package com.eureka.springboot.web.app.stockmarket.api.service.dto;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Repository
public class TimeSeriesDaily {
	
	@JsonProperty("1. open")
    private String open;
    @JsonProperty("2. high")
    private String high;
    @JsonProperty("3. low")
    private String low;
    @JsonProperty("4. close")
    private String close;

}
