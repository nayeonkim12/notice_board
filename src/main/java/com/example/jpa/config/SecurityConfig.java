package com.example.jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration   //config로 사용하는 클래스에 붙이는 @
@EnableWebSecurity   
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
	//super.configure(http);
		
		http.csrf().disable();
		http.headers().frameOptions().sameOrigin();
		
		http.authorizeRequests()
			.anyRequest().permitAll();  //모든 경로에 대해 엑세스를 허용하겠다는 의미
	}

}
