package com.pmi.brick.service;

import org.javatuples.Pair;

import com.pmi.brick.domain.User;

public interface SocialLoginService {
	   public void getAccessToken (String code)  ;
	   public User getUserForLogIn();
	   public User getUserForRegistration();
	   public boolean isRegistrated();
}
