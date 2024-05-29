package com.demo.service;

import com.demo.entity.User;

public interface UserService {

	User createUser(User user);

	User updateUser(int id, User user);

	Iterable<User> getAllUser();

	User getById(Integer id);
	
	void deleteUser(int id);
}
