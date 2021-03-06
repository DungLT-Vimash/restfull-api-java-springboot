package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserDao;
import com.example.demo.entities.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDao userDAO;
	
	public User loadUserByUsername(final String username) {
		return userDAO.loadUserByUsername(username);
	}
	
	public boolean checkLogin(User userForm) {
		return userDAO.checkLogin(userForm);
	}
}
