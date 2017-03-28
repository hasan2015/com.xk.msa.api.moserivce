package com.xk.msa.api.mo.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * 
 * @author yanhaixun
 * @date 2017年3月18日 下午12:23:30
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends AbstractWebSecurityConfig {
	@Override
	protected void setupAuthorization(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// allow anonymous access to /authenticate endpoint
				.antMatchers("/authenticate").permitAll()
				
//	                .antMatchers("/", "/home").permitAll()
//	                .anyRequest().authenticated()
				// allow anonymous to common static resources
//				.antMatchers(HttpMethod.GET, "/", "/*.html", "/favicon.ico", "/**/*.html", "/**/*.css", "/**/*.js")
				 
		; // 2;
	}
}
