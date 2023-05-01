package com.mvc.service;

import com.mvc.mapper.UserMapper;
import com.mvc.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper mapper;

	@Override
	public int join(User user) throws Exception {
		return mapper.join(user);
	}

	@Override
	public int modify(User user) throws Exception {
		return mapper.modify(user);
	}

	@Override
	public User search(String id) throws Exception {
		return mapper.search(id);
	}

	@Override
	public int withdraw(String id) throws Exception {
		return mapper.withdraw(id);
	}

	@Override
	public User login(User user) throws Exception {
		return mapper.login(user);
	}

	@Override
	public int newPw(User user) throws Exception {
		return mapper.newPw(user);
	}
}
