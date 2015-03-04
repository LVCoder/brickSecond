package com.pmi.brick.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import org.javatuples.Pair;
import org.json.simple.parser.ParseException;

import com.pmi.brick.domain.User;

public interface SocialLoginDao {
   public void getAccessToken (String code)  ;
   public User getUserForLogIn();
   public User getUserForRegistration();
   public boolean isRegistrated();
}
