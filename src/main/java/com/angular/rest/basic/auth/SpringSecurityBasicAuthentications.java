package com.angular.rest.basic.auth;

// import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity

public class SpringSecurityBasicAuthentications extends WebSecurityConfigurerAdapter {
 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		

		http
		    .csrf().disable()
			.authorizeRequests()
			.antMatchers("/**").permitAll()
				.anyRequest().authenticated()
				.and()
			//.formLogin().and()
			.httpBasic();
	}
}
