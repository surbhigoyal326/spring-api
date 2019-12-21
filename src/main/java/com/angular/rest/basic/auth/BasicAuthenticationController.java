package com.angular.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BasicAuthenticationController {

	
	
	@GetMapping(path= "/basic-auth")
	public AuthenticationBean authenticationBean() {
		// throw new RuntimeException("Error Occured"); 
		 return new AuthenticationBean("You atre authenticated");
	} 
	
	
}
