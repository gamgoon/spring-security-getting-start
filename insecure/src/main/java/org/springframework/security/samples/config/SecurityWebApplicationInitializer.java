package org.springframework.security.samples.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Registering Spring Security with the war
 * SecurityConfig.java 의 Spring Security 설정을 등록? 해준다.
 * 
 * SecurityWebApplicationInitializer 가 하는 일
 * - Automatically register the springSecurityFilterChain Filter for every URL in your application
 * - Add a ContextLoaderListener that loads the SecurityConfig
 * 
 * @author gamgoon
 *
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	
	public SecurityWebApplicationInitializer () {
		super(SecurityConfig.class);
	}
}
