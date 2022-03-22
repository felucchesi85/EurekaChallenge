package com.eureka.springboot.web.app.stockmarket.api.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eureka.springboot.web.app.stockmarket.api.service.dto.StockMarketServiceResponse;

import java.net.URI;

/**
 *  This suite of APIs provide global equity data in 4 different temporal resolutions: (1) daily, (2) weekly and (3) monthly.
 *   Daily, weekly, and monthly time series contain 20+ years of historical data.
 */
@Service
public class AlphaVantageApiService {
	
	private static final String STOCK_SERVICE_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&outputsize=compact";
    private static final String API_KEY = "X86NOH6II01P7R24";

    public StockMarketServiceResponse getStockMarket(String symbol) {
        StockMarketServiceResponse stockMarketServiceResponse = new StockMarketServiceResponse();
        HttpEntity<String> request = new HttpEntity<>("", getHeaders());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StockMarketServiceResponse> result = restTemplate.exchange(URI.create(getUrl(symbol)), HttpMethod.GET,
                    request, StockMarketServiceResponse.class);
            stockMarketServiceResponse = result.getBody();
        return stockMarketServiceResponse;
    }
    
    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("useQueryString", "true");
        return headers;
    }
    
    private String getUrl(String symbol) {
        return STOCK_SERVICE_URL + "&symbol=" + symbol + "&apikey=" + API_KEY;
    }

}
