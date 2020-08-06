package com.angular.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.springboot.model.UserInfo;
import com.angular.springboot.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public UserInfo addUser(UserInfo userInfo)
	{
		return userRepo.save(userInfo);
	}
	
	public UserInfo findUserMailAndPassword(String userMail, String password) {
		
		return userRepo.findUserInfoByUserMailAndPassword(userMail, password);
	}
	
public UserInfo findUserMail(String userMail) {
		
		return userRepo.findUserInfoByUserMail(userMail);
	}
}
