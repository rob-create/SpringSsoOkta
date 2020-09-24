package com.demo.config;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@Configuration
public class Config extends WebSecurityConfigurerAdapter {

	@Autowired
	ClientRegistrationRepository clientRegistrationRepository;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.anyRequest().authenticated()
				.and().logout().logoutSuccessHandler(logoutSuccessHandler())
				.and()
				.oauth2Login();
	}

	OidcClientInitiatedLogoutSuccessHandler logoutSuccessHandler() {
		OidcClientInitiatedLogoutSuccessHandler handler = new OidcClientInitiatedLogoutSuccessHandler(
				clientRegistrationRepository);
		handler.setPostLogoutRedirectUri(URI.create("http://localhost:8080/"));
		return handler;
	}

}
