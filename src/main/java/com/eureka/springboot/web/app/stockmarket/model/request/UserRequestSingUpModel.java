package com.eureka.springboot.web.app.stockmarket.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserRequestSingUpModel {
	
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	@Email(regexp = ".+[@].+[\\.].+")
	private String email;

}
