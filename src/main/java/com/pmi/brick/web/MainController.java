package com.pmi.brick.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pmi.brick.domain.User;
import com.pmi.brick.service.UserService;

@Controller
public class MainController {

	@Autowired
	protected UserService userService;
	protected User CurrentLogedUser;

	public User getCurrentLogedUser() {
		
			org.springframework.security.core.userdetails.User cur_user = (org.springframework.security.core.userdetails.User) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			String name = cur_user.getUsername(); // get logged in username
			CurrentLogedUser = userService.getUserByEmail(name);
		
		return CurrentLogedUser;
	}
	
	public void logoutCurrentUser(){
		
		CurrentLogedUser=null;
		
	}
	
}
