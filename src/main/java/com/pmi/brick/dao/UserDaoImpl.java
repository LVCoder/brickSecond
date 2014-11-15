package com.pmi.brick.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Query;

import javax.swing.*;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pmi.brick.domain.User;

@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public List<User> getUser() {
		@SuppressWarnings("unchecked")
		List<User> userlist = sessionFactory.getCurrentSession()
				.createCriteria(User.class).list();
		return userlist;
	}

	public String getUserPassword(String email) {
		String password = null;
		Session session = null;
		session = sessionFactory.getCurrentSession();
		User user = null;
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("email", email));
		List results = cr.list();
		if (results.isEmpty())
			return "";
		else
			password = ((User) results.get(0)).getPassword();
		return password;
	}

	public int getUserIdByEmail(String email) {
		int id = 0;
		Session session = null;
		session = sessionFactory.getCurrentSession();
		User user = null;
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("email", email));
		List results = cr.list();
		if (results.isEmpty())
			return -1;
		else
			id = ((User) results.get(0)).getId();
		return id;

	}

	public User getUserById(int id) {
		Session session = null;
		session = sessionFactory.getCurrentSession();
		User user = null;
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("id", id));
		List results = cr.list();
		if (results.isEmpty())
			return null;
		else
			id = ((User) results.get(0)).getId();
		return user;

	}

	@Override
	public User getUserByEmail(String email) {

		User user = new User();

		Session session = null;

		session = sessionFactory.openSession();

		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("email", email));
		List results = cr.list();
		if (results.isEmpty())
			return user;
		else
			user = (User) results.get(0);

		return user;
	}

	public boolean checkEmail(String email) {
		Session session = null;

		session = sessionFactory.openSession();

		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("email", email));
		List results = cr.list();
		if (results.isEmpty())
			return true;
		else
			return false;

	}

}
