package com.pmi.brick.web;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Pair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pmi.brick.aoth2.VKOAuth2Details;
import com.pmi.brick.domain.User;
import com.pmi.brick.exception.EmailAlreadyExistsException;
import com.pmi.brick.service.SocialLoginService;
import com.pmi.brick.utils.Sender;

@Controller
public class VKController extends MainController {
	@Autowired
	SocialLoginService socialLoginService;
	@RequestMapping(value = "/vklogin", method = RequestMethod.GET)
	public String vklogin(Locale locale, Model model) {

		
		String autorizationString=VKOAuth2Details.userAuthorizationUri+"?client_id="+VKOAuth2Details.clientId+"&redirect_uri="+VKOAuth2Details.redirectUri+"&scope="+VKOAuth2Details.scope+"&display="+VKOAuth2Details.display;
	    return "redirect:"+autorizationString;
	    
	}
	@RequestMapping(value = "/vklogincode", method = RequestMethod.GET)
	public ModelAndView vklogincode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model= new ModelAndView();
		String code=request.getParameter("code").toString();
		
		if ( code!=null)
		{
			System.out.println(1);
			socialLoginService.getAccessToken(code);
		    
            if(!socialLoginService.isRegistrated())
            {
            	User user=socialLoginService.getUserForRegistration();
            	CurrentLogedUser=user;
            	//userService.addUser(user);
            	model.setViewName("socreg");
            	
            	System.out.println("vkId"+user.getSocialId());
            	model.addObject("socialUser", user);
            	return model;
            }
               User user=socialLoginService.getUserForLogIn();
               logIn(user);
		    return  new ModelAndView("redirect:/home");
		
		}
		
	return new ModelAndView("redirect:/index");

	}
	@RequestMapping(value = "/socreg", method = RequestMethod.POST)
	public ModelAndView socreg(@ModelAttribute("user") User formUser) throws NoSuchAlgorithmException, EmailAlreadyExistsException 
	{
		if(userService.checkEmail(formUser.getEmail())==false){
			
			throw new EmailAlreadyExistsException("Такий email уже використовується");
	}
		
   Random random=new Random();
	String password=new Integer(random.nextInt()).toString();
	formUser.setPassword(password);
	
	  String to = formUser.getEmail();
      String from = "nazar.gembara@gmail.com";
int rand=random.nextInt();
rand=Math.abs(rand%10000);   //рандомний код, для підвердження email
formUser.setConfirmCode(Integer.toString(rand));
formUser.setEnabled(true);

formUser.setDob(CurrentLogedUser.getDob());
formUser.setSocialId(CurrentLogedUser.getSocialId());
logoutCurrentUser();
authenticateUser(formUser); //аутентифікуєм юзера до хешування паролю
formUser.setPassword(hashing(password));
userService.addUser(formUser);

      Sender sender=new Sender(from,"CaliforniaLove1488"); //username(email) and password.
      sender.send("Email confirmation", "<h1>Hello "+formUser.getName()+",</h1> <p>here is your confirmation number. Go to the email confirmation and input this number there</p>  <h2> "+rand+"</h2>", from, to);
	System.out.println("Save User Data");
	

	return new ModelAndView("redirect:/home");
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
	private void logIn(User user) throws NoSuchAlgorithmException
	{
		  Random random=new Random();
			String password=new Integer(random.nextInt()).toString();
			user.setPassword(password);
			logoutCurrentUser();
			authenticateUser(user); //аутентифікуєм юзера до хешування паролю
			user.setPassword(hashing(password));
			userService.updateUser(user);
	}
	private void authenticateUser(User user) {
		System.out.println("authentificate user");
		SecurityContextHolder.getContext().setAuthentication(
					
				new UsernamePasswordAuthenticationToken(user.getEmail(), user
						.getPassword()));
	}
}
