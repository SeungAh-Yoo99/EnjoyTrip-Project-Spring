package com.mvc.service;

import com.mvc.vo.User;

public interface UserService {
	int join(User user) throws Exception;
	int modify(User user) throws Exception;
	User search(String id) throws Exception;
	int withdraw(String id) throws Exception;
	User login(User user) throws Exception;
	int newPw(User user) throws Exception;
}
