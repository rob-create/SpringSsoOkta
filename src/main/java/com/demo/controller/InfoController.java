package com.demo.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
	
	@GetMapping("/info")
	public void info(OAuth2AuthenticationToken authentication) {
		System.out.println("DATOS AUTHENTICATION");
		System.out.println("authentication.isAuthenticated(): "+authentication.isAuthenticated());
		System.out.println("authentication.getPrincipal(): "+authentication.getPrincipal().getAttributes());
		System.out.println("authentication.getPrincipal(): "+authentication.getPrincipal().getAuthorities());
	}

}
