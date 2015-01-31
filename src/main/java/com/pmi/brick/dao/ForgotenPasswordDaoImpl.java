package com.pmi.brick.dao;

import java.nio.channels.SeekableByteChannel;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pmi.brick.domain.ForgotenPassword;


@Transactional
@Repository("forgotenPasswordDao")
public class ForgotenPasswordDaoImpl implements ForgotenPasswordDao {
	@Autowired
	protected SessionFactory sessionFactory;
	@SuppressWarnings("deprecation")
	@Override
	public int getUserId(int id, String hash_password) {
		int user_id;
	    
		Session session = null;
		session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(ForgotenPassword.class);
		cr.add(Restrictions.eq("id", id));
		cr.add(Restrictions.eq("hash_password", hash_password));
		@SuppressWarnings("unchecked")
		List<ForgotenPassword> results = cr.list();
		if (results.isEmpty())
			return -1;
		else
		{
			if (results.get(0).getisIs_used())
				return -1;
			Date now=new Date();
			Date forgotDate= results.get(0).getDate();	
			if( now.getTime()-forgotDate.getTime()>86400000) // check, is the difference less then 24 hours
				return -1;
			
			user_id = results.get(0).getUser_id();
			results.get(0).setIs_used(true);
			sessionFactory.getCurrentSession().update(results.get(0));
		return user_id;
		}
		
	}
	@Override
	public void saveForgotenPassword(ForgotenPassword forgotenpassword) {
		sessionFactory.getCurrentSession().save(forgotenpassword);
		
	}
	@Override
	public void delete(ForgotenPassword forgotenPassword) {
		sessionFactory.getCurrentSession().delete(forgotenPassword);
	
		
	}
	


}
