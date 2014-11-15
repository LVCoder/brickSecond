package com.pmi.brick.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pmi.brick.domain.User;

@Component
public interface UserDao {
	public void saveUser(User user);

	public String getUserPassword(String email);

	public int getUserIdByEmail(String email);

	public User getUserById(int id);

	public User getUserByEmail(String email);

	public List<User> getUser();

	public boolean checkEmail(String email);

}
