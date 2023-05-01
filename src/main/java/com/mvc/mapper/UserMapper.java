package com.mvc.mapper;

import com.mvc.vo.User;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface UserMapper {
	int join(User user) throws SQLException;
	int modify(User user) throws SQLException;
	User search(String id) throws SQLException;
	int withdraw(String id) throws SQLException;
	User login(User user) throws SQLException;
	int newPw(User user) throws SQLException;
}
