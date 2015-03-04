package com.pmi.brick.service;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pmi.brick.dao.SocialLoginDao;
import com.pmi.brick.domain.User;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SocialLoginServiceImpl implements SocialLoginService {
    @Autowired
    SocialLoginDao socialLoginDao;

	@Override
	public void getAccessToken(String code) {
		// TODO Auto-generated method stub
		 socialLoginDao.getAccessToken(code);
	}

	@Override
	public User getUserForLogIn() {
		// TODO Auto-generated method stub
		return socialLoginDao.getUserForLogIn();
	}

	@Override
	public User getUserForRegistration() {
		// TODO Auto-generated method stub
		return socialLoginDao.getUserForRegistration();
	}

	@Override
	public boolean isRegistrated() {
		// TODO Auto-generated method stub
		return socialLoginDao.isRegistrated();
	}


}
