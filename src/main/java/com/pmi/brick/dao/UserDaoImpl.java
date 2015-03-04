package com.pmi.brick.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pmi.brick.domain.User;

import org.hibernate.Transaction;

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
	public void updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();

		session.update(user);

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
		List<User> results = cr.list();
		if (results.isEmpty())
			return "";
		else
			password = results.get(0).getPassword();
		return password;
	}

	public int getUserIdByEmail(String email) {
		int id = 0;
		Session session = null;
		session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("email", email));
		@SuppressWarnings("unchecked")
		List<User> results = cr.list();
		if (results.isEmpty())
			return -1;
		else
			id = results.get(0).getId();
		return id;

	}

	public User getUserById(int id) {
		User user = new User();

		Session session = null;

		session = sessionFactory.openSession();

		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("id", id));
		List<User> results = cr.list();
		session.close();
		if (results.isEmpty())
			return user;
		else
			user = results.get(0);

		return user;

	}

	@Override
	public User getUserByEmail(String email) {

		User user = new User();

		Session session = null;

		session = sessionFactory.openSession();

		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("email", email));
		@SuppressWarnings("unchecked")
		List<User> results = (List<User>)cr.list();
		session.close();
		if (results.isEmpty())
			return user;
		else
			user = results.get(0);

		return user;
	}

	public boolean checkEmail(String email) { // return true if email dooes not
		// exist in Data Base
		Session session = null;

		session = sessionFactory.openSession();

		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("email", email));
		List<User> results = cr.list();
		session.close();
		if (results.isEmpty())
			return true;
		else
			return false;

	}

	@Override
	public User getUserBySocialId(String socialId) {
		User user = new User();

		Session session = null;

		session = sessionFactory.openSession();

		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("socialId", socialId));
		@SuppressWarnings("unchecked")
		List<User> results = (List<User>)cr.list();
		session.close();
		
		if (results.isEmpty())
			return null;
		else
			user = results.get(0);

		return user;
	}

}
