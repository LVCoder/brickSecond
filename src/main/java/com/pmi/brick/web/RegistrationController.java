package com.pmi.brick.web;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.pmi.brick.domain.User;
import com.pmi.brick.exception.EmailAlreadyExistsException;
import com.pmi.brick.service.UserService;
import com.pmi.brick.exception.*;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Locale locale, Model model) {

		return "reg";
	}

	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView saveUserData(@ModelAttribute("user") User user,
			BindingResult result, HttpServletResponse response) throws EmailAlreadyExistsException {
		
		if(userService.checkEmail(user.getEmail())==false){
			
				throw new EmailAlreadyExistsException("Такий email уже використовується");
		}
				
		userService.addUser(user);

		System.out.println("Save User Data");
		authenticateUser(user);

		return new ModelAndView("redirect:/home");
	}
	
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ModelAndView handleEmailAlreadyExistException(EmailAlreadyExistsException exception) {
		ModelAndView modelAndView = new ModelAndView("reg");
		modelAndView.addObject("emailErrorMessage", exception.getMessage());
		return modelAndView;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception exception) {
		ModelAndView modelAndView = new ModelAndView("reg");
		modelAndView.addObject("errorMessage", exception.getMessage());
		return modelAndView;
	}
 
	
	public void authenticateUser(User user) {
		SecurityContextHolder.getContext().setAuthentication(
				new UsernamePasswordAuthenticationToken(user.getEmail(), user
						.getPassword()));
	}

}
