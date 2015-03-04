package com.pmi.brick.dao;

import java.awt.event.PaintEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pmi.brick.aoth2.VKOAuth2Details;
import com.pmi.brick.domain.User;
import com.pmi.brick.domain.User.Gender;

@Transactional
@Repository("socialLoginDao")
public class SocialLoginDaoImpl implements SocialLoginDao {
	@Autowired
	UserDao userDao;
   private String accessToken;
   private String userId;
	private String email;
	@Override
	public  void getAccessToken(String code)  {
		try{
		String accessTokenString=VKOAuth2Details.accessTokenUri+"?client_id="+VKOAuth2Details.clientId+"&client_secret="+VKOAuth2Details.clientSecret+"&code="+code+"&redirect_uri="+VKOAuth2Details.redirectUri;			
		 URL myurl = new URL(accessTokenString);
		    HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
		    InputStream ins = con.getInputStream();
		    InputStreamReader isr = new InputStreamReader(ins,"UTF-8");   
		    JSONParser parser=new JSONParser();
		    JSONObject jObject=(JSONObject)parser.parse(isr);	
		    accessToken=jObject.get("access_token").toString();
		    userId= jObject.get("user_id").toString();
		    email=jObject.get("email").toString();
		  //  getUserFromSocNet();
		
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	@Override
	public User getUserForRegistration()
	{
	    
	    return getUserFromSocNet( );
	    	
	    
	}
	@Override
	public boolean isRegistrated()
	{
		if (userDao.getUserBySocialId("vk"+userId)!=null)
			return true;
		return false;
	}
	private User getUserFromSocNet()
	{
try{
	
		String methodString=VKOAuth2Details.methodUri+"users.get?user_ids="+userId+"&fields=city,sex,bdate&v=5.28&access_token="+accessToken+"&lang=ua";
	    URL newUrl=new URL(methodString);
	    HttpsURLConnection con=(HttpsURLConnection)newUrl.openConnection();
	    InputStream ins=con.getInputStream();  
	    
	    InputStreamReader newIsr=new InputStreamReader(ins,"UTF-8");
	    JSONParser parser=new JSONParser();
		JSONObject response= (JSONObject)parser.parse(newIsr);
		System.out.println(response.toJSONString());
		JSONArray jsonUsers=(JSONArray) response.get("response");
		JSONObject jsonUser=(JSONObject) jsonUsers.get(0);
	
	    User user=new User();
	    user.setSocialId("vk"+userId);
	    user.setEmail(email);
	    user.setName(jsonUser.get("first_name").toString());
	    
	    user.setSurname(jsonUser.get("last_name").toString());

	    if (jsonUser.get("city")!=null)
	    {
	    	JSONObject jsonCity=(JSONObject) jsonUser.get("city");
	    user.setCity(jsonCity.get("title").toString());
	    }
        if (jsonUser.get("bdate")!=null ){
	    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
	    user.setDob(formatter.parse(jsonUser.get("bdate").toString()));
        }
        if ( jsonUser.get("sex")!=null){
	    int sex=Integer.parseInt(jsonUser.get("sex").toString());
	    
	    switch(sex)
	    {
	    case 1: user.setGender(Gender.Female); break;
	    case 2: user.setGender(Gender.Male); break;
	    default : user.setGender(Gender.Unknown); break;
	    }
        }
        System.out.println("id="+user.getSocialId());
        return user;
}
catch ( Exception e)
{
	System.out.println(e.getMessage());
	}
	return null;
	}

	
	@Override
	public User getUserForLogIn() {
		
		return userDao.getUserBySocialId("vk"+userId);
	}
}
