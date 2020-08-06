package com.angular.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angular.springboot.model.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

	public UserInfo findUserInfoByUserMailAndPassword(String userMail, String password);

	public UserInfo findUserInfoByUserMail(String userMail);
	
}
