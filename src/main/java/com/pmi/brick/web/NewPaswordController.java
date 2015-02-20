package com.pmi.brick.web;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.pmi.brick.domain.ForgotenPassword;
import com.pmi.brick.domain.User;
import com.pmi.brick.service.ForgotenPasswordService;
import com.pmi.brick.utils.Sender;
@Controller
public class NewPaswordController extends MainController{
	@Autowired
	  ForgotenPasswordService forgotenPasswordService;
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public String forgotClick(Locale locale, Model model) {

		return "forgotPassword";
	}
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public ModelAndView sendMessage(@RequestParam("email") String email) throws NoSuchAlgorithmException {
       


	if (userService.getUserIdByEmail(email)!=-1)
	{
		User user=userService.getUserByEmail(email);
	    ForgotenPassword forgotenPassword= new ForgotenPassword();
	    forgotenPassword.setUser_id(user.getId());
	    forgotenPassword.setDate(new Date());
	    Random r=new Random(47);
	    String beforeHash=((Integer)r.nextInt()).toString();
	    String afterHash=hashing(beforeHash);
	    forgotenPassword.setHash_password(afterHash);
	    forgotenPasswordService.addForgotenPassword(forgotenPassword);
	    String to = email;
	    String from = "nazar.gembara@gmail.com";
	    String link= "http://localhost:8080/brick/newPassword/"+forgotenPassword.getId()+"/"+forgotenPassword.getHash_password();
	    Sender sender=new Sender(from,"CaliforniaLove1488"); //username(email) and password.
	      sender.send("ForgotenPassword", "<h1>Hello "+user.getName()+", Here is a link for seting your new password</h1> "+link , from, to);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sendEnding");
	    modelAndView.addObject("emailSendSuccessful", "Лист успішно надіслано");
		return modelAndView;
	}
	else{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("forgotPassword");
	  modelAndView.addObject("emailSendingFailed", "Невірий email");
		return modelAndView;
	}
		
	}
	
	@RequestMapping(value = "/newPassword/{urlId}/{urlHash}", method = RequestMethod.GET)
	public ModelAndView dataChek(@PathVariable("urlId") Integer passwordId,@PathVariable("urlHash") String hash)
	{
		
		int userId=forgotenPasswordService.getUserId(passwordId, hash);
		if (userId!=-1)
		{
			
			ModelAndView model=new ModelAndView();
			
			
			model.addObject("userId", userId);
			model.setViewName("newPassword");
		
			return model;
		}
		else 
		{
			ModelAndView model=new ModelAndView();
			model.addObject("wrongLink", "Wrong data,ERROR");// Треба поміняти
			model.setViewName("sendEnding");
			return model;
		}
	}
	

	@RequestMapping(value = "/newPassword/{neverUsed}/{userId}", method = RequestMethod.POST)
	public ModelAndView setNewPassword( @PathVariable("userId") int userId, @RequestParam("password") String password) throws NoSuchAlgorithmException
	{
		User user=userService.getUserById(userId);
		user.setPassword(password);
		String hashedPass=hashing(password);
	   
		user.setPassword(hashedPass);
		userService.updateUser(user);
		return new ModelAndView("redirect:/login");
	}

	private String hashing(String iNeedHash) throws NoSuchAlgorithmException
	{
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");  
		messageDigest.update(iNeedHash.getBytes(),0, iNeedHash.length());  
		String hashed = new BigInteger(1,messageDigest.digest()).toString(16);  
		if (hashed.length() < 32) {
		   hashed = "0" + hashed; 
		}
		return hashed;
	}
}
