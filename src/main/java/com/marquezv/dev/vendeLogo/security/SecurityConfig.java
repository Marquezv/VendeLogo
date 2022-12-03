package com.marquezv.dev.vendeLogo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.requestMatchers(HttpMethod.GET).permitAll()
			.requestMatchers(HttpMethod.POST).permitAll()
			.anyRequest().permitAll()
			.and()
			.httpBasic();
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService users() {
		UserDetails admin = User.builder()
			.username("admin")
			.password("$2a$12$v/pQqMq/AcRSwhe4A7CsS.xUJx0nOb/Cn8p0fP3Y5BJVFce0u5qym")
			.roles("ADMIN")
			.build();

		UserDetails user = User.builder()
			.username("user")
			.password("password")
			.roles("USER")
			.build();
		
		return new InMemoryUserDetailsManager(admin, user);
	}
	
}
