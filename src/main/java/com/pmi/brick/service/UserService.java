package com.pmi.brick.service;

import java.util.List;

import com.pmi.brick.domain.User;

public interface UserService {
	public void addUser(User user);

	public void updateUser(User user);
	public boolean checkUserPassword(String email, String password);

	public boolean checkEmail(String email); // returns FALSE if already exist,
												// and TRUE if not.
	public boolean checkEmailForForgotenPassword(String email); 
	public int getUserIdByEmail(String email);

	public List<User> getUser();

	public User getUserByEmail(String email);
	public User getUserById(int id);

	public void confirmEmail(User user);
}
