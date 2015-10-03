package org.springframework.security.samples.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Creating Spring Security configuration
 * @EnableWebSecurity, @EnableGlobalMethodSecurity or @EnableGlobalAuthentication 어노테이션이 설정된
 * 클래스에 AuthenticationManagerBuilder 를 설정해야한다.
 * 
 * - Require authentication to every URL in your application // 이것만으로 Spring security 설정이 되는거군. 
 * - Generate a login form for you (오~)
 * - Allow the user with the <strong>Username</strong> user and the <strong>Password</strong> password to authenticate with form based authentication
 * - Allow the user to logout
 * - CSRF attack prevention (CSRF 공격이 뭐지? https://ko.wikipedia.org/wiki/%EC%82%AC%EC%9D%B4%ED%8A%B8_%EA%B0%84_%EC%9A%94%EC%B2%AD_%EC%9C%84%EC%A1%B0)
 * 		- XSS(사이트 간 스크립팅 https://ko.wikipedia.org/wiki/%EC%82%AC%EC%9D%B4%ED%8A%B8_%EA%B0%84_%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8C%85)
 * - Session Fixation protection (https://en.wikipedia.org/wiki/Session_fixation)
 * - Security Header integration
 * 		- HTTP Strict Transport Security for secure requests
 * 		- X-Content-Type-Options integration
 * 		- Cache Control (can be overridden later by your application to allow caching of your static resources)
 *   	- X-XSS-Protection integration
 *   	- X-Frame-Options integration to help prevent Clickjacking
 * - Integrate with the following Servlet API methods
 * 		- HttpServletRequest#getRemoteUser()
 * 		- HttpServletRequest.html#getUserPrincipal()
 * 		- HttpServletRequest.html#isUserInRole(java.lang.String)
 * 		- HttpServletRequest.html#login(java.lang.String, java.lang.String)
 * 		- HttpServletRequest.html#logout()
 * 
 * Security Header 부터는 잘 모르는 내용들이많음;;
 * 
 * @author gamgoon
 *
 */
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");	// 우선은 인메모리 인증?
	}
}
