package com.mvc.service;

import java.util.ArrayList;
import java.util.List;

import com.mvc.vo.Customer;

public interface CustomerService {
	ArrayList<Customer> selectAll() throws Exception;
	Customer selectOne(String num) throws Exception;
	int insert(Customer c) throws Exception;
	int modify(Customer c) throws Exception;
	int delete(String num) throws Exception;
	List<Customer> findByAddress(String address) throws Exception;
}
