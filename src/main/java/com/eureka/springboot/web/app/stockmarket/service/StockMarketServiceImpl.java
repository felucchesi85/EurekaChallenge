package com.eureka.springboot.web.app.stockmarket.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.eureka.springboot.web.app.stockmarket.api.service.AlphaVantageApiService;
import com.eureka.springboot.web.app.stockmarket.api.service.dto.ServiceResponse;
import com.eureka.springboot.web.app.stockmarket.api.service.dto.StockMarketServiceResponse;
import com.eureka.springboot.web.app.stockmarket.api.service.dto.TimeSeriesDaily;
import com.eureka.springboot.web.app.stockmarket.entities.User;
import com.eureka.springboot.web.app.stockmarket.exception.UserException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class StockMarketServiceImpl implements StockMarketService {

	private final Logger logger = LoggerFactory.getLogger(StockMarketServiceImpl.class);

	@Autowired
	private AlphaVantageApiService alphaVantageApiService;

	StockMarketServiceImpl(AlphaVantageApiService alphaVantageApiService) {
		this.alphaVantageApiService = alphaVantageApiService;
	}

	/**
	 *  This method provides utility that allow authenticate the user.
	 * @param firstName, lastName, email
	 * @return Returns a User object representing the user entity.
	 * @throws Exception
	 */
	@Override
	public User signUpUser(String firstName, String lastName, String email) throws Exception {
		logger.info("StockMarketServiceImpl::signUpUser() method call..." + " " + "firstName: " + firstName +" "+ "lastName: " + lastName + " "+ "email: " + email+" ");
		try {
			if ((firstName == null || firstName.isEmpty())
					&& (lastName == null || lastName.isEmpty())){
				throw new UserException("First name or last name cannot be null");
			}
			if (email == null || email.isEmpty() ) {
				throw new UserException("Email cannot be null");
			}
			User user = new User(firstName,lastName, email);
			user.setToken(getJWTToken(email));
			return user;
		} catch (Exception e) {
            throw new UserException(" "+ e + " .");
		}
	}


	/**
	 *  Returns raw (as-traded) daily time series (date, daily open, daily high, daily low, daily close) of the global equity specified.
	 * @param symbol
	 * @return Returns a ServiceResponse object representing the stock market.
	 * @throws Exception
	 */
	@Override
	public ServiceResponse getStockData(String symbol) throws Exception {
		logger.info("StockMarketServiceImpl::getStockData() method call...");
		try {
			Double lastClose;
			Double previousClose;
			StockMarketServiceResponse stockMarketServiceResponse = alphaVantageApiService.getStockMarket(symbol);
			List<TimeSeriesDaily> keys = stockMarketServiceResponse.getTimeSeriesDaily().values().stream().limit(2)
					.collect(Collectors.toList());
			ServiceResponse serviceResponse = new ServiceResponse();
			serviceResponse.setOpenPrice(keys.get(0).getOpen());
			serviceResponse.setHigherPrice(keys.get(0).getHigh());
			serviceResponse.setLowerPrice(keys.get(0).getLow());
			lastClose = Double.valueOf(keys.get(0).getClose());
			previousClose = Double.valueOf(keys.get(1).getClose());
			serviceResponse.setTwoDayVariation(Double.toString(lastClose - previousClose));
			return serviceResponse;
		} catch (Exception e) {
	        throw new UserException("Service exception when call alphaVantageApiService");
		}
	}
	
	/**
	 *  Retrieves the actual object which represents the JWT token for the current user.
	 * @param username
	 * @return Returns a {@link Jwt} object representing the user's access token. 
	 */
	private String getJWTToken(String username){
		logger.info("StockMarketServiceImpl::getJWTToken() method call...");
		String secretKey = "key";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		String token = Jwts.builder().setId("EUREKA").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
