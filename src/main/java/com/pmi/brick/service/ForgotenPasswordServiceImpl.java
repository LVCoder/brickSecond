package com.pmi.brick.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pmi.brick.dao.ForgotenPasswordDao;
import com.pmi.brick.domain.ForgotenPassword;
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ForgotenPasswordServiceImpl implements ForgotenPasswordService {
    @Autowired
    private ForgotenPasswordDao fpDao;
	

	public void addForgotenPassword(ForgotenPassword forgotenPassword) {
		fpDao.saveForgotenPassword(forgotenPassword);

	}

	
	public int getUserId(int id, String hashPassword) {
		return fpDao.getUserId(id, hashPassword);
	}





	@Override
	public void delete(ForgotenPassword forgotenPassword) {
		fpDao.delete(forgotenPassword);
	}




}
