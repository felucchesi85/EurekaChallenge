package com.eureka.springboot.web.app.stockmarket.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class User {

	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	@Email(regexp = ".+[@].+[\\.].+")
	private String email;
	private String token;	
	
   public User(String firstName, String lastName, String email){
	   this.firstName = firstName;
	   this.lastName = lastName;
	   this.email = email;
    }

}
