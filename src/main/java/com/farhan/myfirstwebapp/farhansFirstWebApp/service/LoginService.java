package com.farhan.myfirstwebapp.farhansFirstWebApp.service;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
	public boolean validateUser(String user, String password) {
        return user.equalsIgnoreCase("farhan") 
        		&& password.equals("12345");
    }
}
