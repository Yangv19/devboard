package com.vincentdevboard.app.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vincentdevboard.app.DAO.UserDAO;
import com.vincentdevboard.app.entities.User;
import com.vincentdevboard.app.exceptions.SingleException;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public String createUser(User newUser) {
		try {
			newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
			userDAO.create(newUser);
			return newUser.getUserId();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new SingleException("User already exists");
		}
	}
	
	public User findUserByEmail(String email) {
		return userDAO.findUserByEmail(email);
	}
	
	public User findUserById(String id) {
		return userDAO.findUserById(id);
	}
	
	public User updateUserImage(String id, MultipartFile file) {
		return userDAO.updateUserImage(id, file);
	}
	
	public void deleteUser(String id) {
		userDAO.deleteUser(id);
	}
}
