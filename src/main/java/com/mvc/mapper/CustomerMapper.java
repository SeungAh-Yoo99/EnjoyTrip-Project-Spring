package com.mvc.mapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.vo.Customer;

@Mapper
public interface CustomerMapper {
	ArrayList<Customer> selectAll() throws SQLException;
	Customer selectOne(String num) throws SQLException;
	int insert(Customer c) throws SQLException;
	int modify(Customer c) throws SQLException;
	int delete(String num) throws SQLException;
	List<Customer> findByAddress(String address);
}
