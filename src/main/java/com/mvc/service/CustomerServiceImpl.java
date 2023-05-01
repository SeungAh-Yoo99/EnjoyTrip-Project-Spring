package com.mvc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.mapper.CustomerMapper;
import com.mvc.vo.Customer;

//Controller에서 넘어온 요청을 처리하는 객체 =>DAO객체에 전달해서 결과를 받음
//BoardService에서 선언한 추상 메소드의 내용을 실제 완성해 놓은 클래스

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerMapper mapper;

	@Override
	public ArrayList<Customer> selectAll() throws Exception{
		return mapper.selectAll();
	}

	@Override
	public Customer selectOne(String num) throws Exception{
		return mapper.selectOne(num);
	}

	@Override
	public int insert(Customer c) throws Exception{		
		return mapper.insert(c);
	}
	
	@Override
	public int modify(Customer c) throws Exception {
		return mapper.modify(c);
	}

	@Override
	public int delete(String num) throws Exception{
		return mapper.delete(num);
	}

	@Override
	public List<Customer> findByAddress(String address) throws Exception{
		return mapper.findByAddress(address);
	}
}
