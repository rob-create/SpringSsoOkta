package com.demo.controller;
import java.util.Collections;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DemoController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}	
	@GetMapping("/profile")
	public ModelAndView userData(OAuth2AuthenticationToken authenticationToken) {
		
		return new ModelAndView("profile", Collections.singletonMap("details", authenticationToken.getPrincipal().getAttributes()));
			
	}

}
