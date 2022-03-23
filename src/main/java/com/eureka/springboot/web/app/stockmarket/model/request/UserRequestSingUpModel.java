package com.eureka.springboot.web.app.stockmarket.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserRequestSingUpModel {
	
	private String firstName;
	
	private String lastName;

	@Email(message = "Email must be a valid email address")
	private String email;

}
