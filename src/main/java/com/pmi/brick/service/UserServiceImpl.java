package com.pmi.brick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pmi.brick.dao.UserDao;
import com.pmi.brick.dao.UserDaoImpl;
import com.pmi.brick.domain.User;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(User user) {
		user.setAuthority("ROLE_USER");
		userDao.saveUser(user);
	}

	@Override
	public List<User> getUser() {
		return userDao.getUser();
	}

	public boolean checkUserPassword(String email, String password) {

		if (password.equals(userDao.getUserPassword(email)))
			return true;

		return false;
	}

	public int getUserIdByEmail(String email) {

		return userDao.getUserIdByEmail(email);
	}

	@Override
	public User getUserByEmail(String email) {

		return userDao.getUserByEmail(email);
	}

	public boolean checkEmail(String email) {

		return userDao.checkEmail(email);
	}

}
