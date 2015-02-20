package com.pmi.brick.web;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
import com.pmi.brick.utils.Sender;
import com.pmi.brick.exception.*;

@Controller
public class RegistrationController extends MainController{



	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Locale locale, Model model) {

		return "reg";
	}
	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public String showConfirmEmailForm(Locale locale, Model model) {
         if(getCurrentLogedUser().getIsEmailConfirm()==false)
		return "registration/emailConfirmation";
         else
        	 return "redirect:/home";
	}
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public ModelAndView confirmEmail(@ModelAttribute("user") User userFromForm, BindingResult result, HttpServletResponse response) {

User user=getCurrentLogedUser();
	if((userFromForm.getConfirmCode()).compareTo(user.getConfirmCode())==0){
		userService.confirmEmail(getCurrentLogedUser());
		user.setIsEmailConfirm(true);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("current_user", user);
		modelAndView.setViewName("home");
	    modelAndView.addObject("emailConfirmSuccessful", "Ваш email підтверджено");
		return modelAndView;
	}
	else{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("registration/emailConfirmation");
	  modelAndView.addObject("emailConfirmFailed", "Код який ви увели не співпадає з кодом улисті");
		return modelAndView;
	}
		
	}

	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView saveUserData(@ModelAttribute("user") User user,
			BindingResult result, HttpServletResponse response) throws EmailAlreadyExistsException, NoSuchAlgorithmException {
		
		if(userService.checkEmail(user.getEmail())==false){
			
				throw new EmailAlreadyExistsException("Такий email уже використовується");
		}
				
		
		  String to = "lemberg.ukraine@gmail.com";
	      String from = "nazar.gembara@gmail.com";
int rand=new Random().nextInt();
rand=Math.abs(rand%10000);   //рандомний код, для підвердження email
user.setConfirmCode(Integer.toString(rand));
user.setEnabled(true);
//хешування паролю, MD5
MessageDigest messageDigest = MessageDigest.getInstance("MD5");  
messageDigest.update(user.getPassword().getBytes(),0, user.getPassword().length());  
String hashedPass = new BigInteger(1,messageDigest.digest()).toString(16);  
if (hashedPass.length() < 32) {
   hashedPass = "0" + hashedPass; 
}
logoutCurrentUser();
authenticateUser(user); //аутентифікуєм юзера до хешування паролю
user.setPassword(hashedPass);
userService.addUser(user);

	      Sender sender=new Sender(from,"CaliforniaLove1488"); //username(email) and password.
	      sender.send("Email confirmation", "<h1>Hello "+user.getName()+",</h1> <p>here is your confirmation number. Go to the email confirmation and input this number there</p>  <h2> "+rand+"</h2>", from, to);
		System.out.println("Save User Data");
		

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
		modelAndView.addObject("errorMessage", "Сталась помилка "+exception.getMessage());
		return modelAndView;
	}
 
	
	public void authenticateUser(User user) {
		System.out.println("authentificate user");
		SecurityContextHolder.getContext().setAuthentication(
					
				new UsernamePasswordAuthenticationToken(user.getEmail(), user
						.getPassword()));
	}

}
