package com.pmi.brick.web;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Locale;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VKController {
	@RequestMapping(value = "/vklogin", method = RequestMethod.GET)
	public String vklogin(Locale locale, Model model) {

		System.out.println("VKLogin");
		return "redirect:https://oauth.vk.com/authorize?client_id=4760386&redirect_uri=http://localhost:8080/brick/vklogincode&scope=email&display=page";
	}
	@RequestMapping(value = "/vklogincode", method = RequestMethod.GET)
	public String vklogincode(HttpServletRequest request, HttpServletResponse response) throws Exception {
       
		String code=request.getParameter("code").toString();
		if ( code!=null)
		{
		System.out.println(code);
		 String httpsURL = "https://api.vk.com/oauth/access_token?client_id=4760386&client_secret=fm6rYRXm6q2WSs14f5wr&code="+code+"&redirect_uri=http://localhost:8080/brick/vklogincode";
		
		 URL myurl = new URL(httpsURL);
		    HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
		    InputStream ins = con.getInputStream();
		    InputStreamReader isr = new InputStreamReader(ins,"UTF-8");
		    
		    JSONParser parser=new JSONParser();
		    JSONObject jObject=(JSONObject)parser.parse(isr);
		    
		    System.out.println(jObject.get("access_token"));
		    System.out.println(jObject.get("user_id"));
		    
		    String Url="https://api.vk.com/method/users.get?user_id="+jObject.get("user_id")+"&v=5.28&access_token="+jObject.get("access_token")+"&lang=ua";
		    URL newUrl=new URL(Url);
		    con=(HttpsURLConnection)newUrl.openConnection();
		    ins=con.getInputStream();
		    
		    InputStreamReader newIsr=new InputStreamReader(ins,"UTF-8");
		    
			JSONObject user= (JSONObject)parser.parse(newIsr);
		    String stringuser=user.get("response").toString();
			stringuser=stringuser.subSequence(1, stringuser.length()-1).toString();
			
			//stringuser=stringuser.replaceAll(regex, replacement)
			user=(JSONObject)parser.parse(stringuser);
		   System.out.println(user.get("first_name"));
		 //   System.out.println(user.get("response"));
		    return "redirect:login";
		}
		else 
		{
			
		         String token=request.getParameter("access_token").toString();
				System.out.println(token);
				return "redirect:login";
		}
		}

}
