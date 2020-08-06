package com.angular.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular.springboot.model.UserInfo;
import com.angular.springboot.service.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserInfo> addNewUser(@RequestBody UserInfo userInfo) throws Exception{
		String userMail = userInfo.getUserMail();
		if(userMail != null || "" != userMail) {
		UserInfo user = userService.findUserMail(userMail);
		if(user != null) {
			throw new Exception("user with"+userMail+ "already exists");
		}
		}
		UserInfo newUser = null;
		newUser = userService.addUser(userInfo);
		return new ResponseEntity<>(newUser, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserInfo> loginUser(@RequestBody UserInfo userInfo) throws Exception{
		String userMail = userInfo.getUserMail();
		String password  = userInfo.getPassword();
		UserInfo user = null;
		if(userMail != null || "" != userMail || password != null || "" != password) {
		user = userService.findUserMailAndPassword(userMail, password);
		}
		if(user == null) {
			throw new Exception("Login Information is Incorrect");
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
