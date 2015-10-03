package org.springframework.security.samples.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// @formatter:off
	@Autowired
	public void configureGlobal(
			AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER");
	}
	// @formatter:on

	/**
	 * The line loginPage("/login") instructs Spring Security
	 * when authentication is required, redirect the browser to /login
	 * we are in charge of rendering the login page when /login is requested
	 * when authentication attempt fails, redirect the browser to /login?error (since we have not specified otherwise)
	 * we are in charge of rendering a failure page when /login?error is requested
	 * when we successfully logout, redirect the browser to /login?logout (since we have not specified otherwise)
	 * we are in charge of rendering a logout confirmation page when /login?logout is requested
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/resources/**").permitAll()	
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
			
	}
	
	
}
