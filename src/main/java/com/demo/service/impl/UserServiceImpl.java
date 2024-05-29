package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.repo.UserRepo;
import com.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User createUser(User user) {

		return userRepo.save(user);
	}

	@Override
	public User updateUser(int id, User user) {
		User findUser = userRepo.findById(id).orElseThrow(null);
		if (findUser != null) {
			findUser.setAddress(user.getAddress());
			findUser.setEmail(user.getEmail());
			findUser.setName(user.getName());

			User save = userRepo.save(user);
			return save;
		}
		return null;
	}

	@Override
	public Iterable<User> getAllUser() {

		return userRepo.findAll();
	}

	@Override
	public User getById(Integer id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).get();
	}

	@Override
	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}

}
