package com.eureka.springboot.web.app.stockmarket.service;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.eureka.springboot.web.app.stockmarket.api.service.AlphaVantageApiService;
import com.eureka.springboot.web.app.stockmarket.api.service.dto.MetaData;
import com.eureka.springboot.web.app.stockmarket.api.service.dto.StockMarketServiceResponse;
import com.eureka.springboot.web.app.stockmarket.api.service.dto.TimeSeriesDaily;


class StockMarketServiceImplTest {
	
	@Autowired
	StockMarketServiceResponse stockMarketServiceResponse;
	
	@Autowired
	MetaData metaData;
	
	@Autowired
	TimeSeriesDaily timeSeriesDaily;
	
	/**
	 *  This test is created to mock the behavior of AlphaVantage Api Service with use MOCKITO library
	 * @return Returns Alpha Vantage API.
	 * @throws Exception
	 */
    @Test void getStockDataTest() throws Exception {
    	AlphaVantageApiService alphaVantageApiService = mock(AlphaVantageApiService.class);
	  
		TimeSeriesDaily timeSeriesDaily = new TimeSeriesDaily();
		StockMarketServiceResponse stockMarketServiceResponse= new StockMarketServiceResponse();
		Map<String,TimeSeriesDaily> timeSeriesDailyMap= new LinkedHashMap<>(); stockMarketServiceResponse.setMetaData(metaData);
		timeSeriesDaily.setOpen("2614.6600");
		timeSeriesDaily.setLow("2574.6900");
		timeSeriesDaily.setHigh("2666.6600");
		timeSeriesDaily.setClose("2520.00009");
		timeSeriesDailyMap.put(null,timeSeriesDaily);
		stockMarketServiceResponse.setTimeSeriesDaily(timeSeriesDailyMap);
		String symbol= "GOOGL";
		when(alphaVantageApiService.getStockMarket(symbol)).thenReturn(
		stockMarketServiceResponse);
		  
		assertNotNull(timeSeriesDaily);
	}
	 

}
