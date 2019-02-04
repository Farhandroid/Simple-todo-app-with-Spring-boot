package com.farhan.myfirstwebapp.farhansFirstWebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.farhan.myfirstwebapp.farhansFirstWebApp.service.LoginService;

@Controller
@SessionAttributes("name")
public class WelComeController {

	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap modelMap) {
		modelMap.put("name", getLoggedInUserName(modelMap));
		return "welcome_after_login";
	}
	
	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
}
