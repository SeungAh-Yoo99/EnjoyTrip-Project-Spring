package com.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.service.CustomerService;
import com.mvc.vo.Car;
import com.mvc.vo.Customer;

import io.swagger.annotations.ApiOperation;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService service;

	@GetMapping(value = "/customers")
	@ApiOperation(notes="전체 Customer 목록을 조회합니다.", value="전체목록")
	public List<Customer> list(Model model) throws Exception{
		return service.selectAll();
	}
	
	@GetMapping(value = "/customers/{num}")
	@ApiOperation(notes="num에 해당하는 Customer 객체를 조회합니다.", value="Customer 객체 조회")
    public Customer read(@PathVariable String num) throws Exception {
        return service.selectOne(num);
    }
	
	@PostMapping(value = "/customers")
	@ApiOperation(notes="Customer 객체를 추가 합니다.", value="Customer 객체 등록")
    public Map<String, String> insert(@RequestBody Customer c) throws Exception {
        int x = service.insert(c);
        
        Map<String, String> map = new HashMap<>();
        if(x >= 1) map.put("result", "insert success!");
        else map.put("result", "insert fail!");
        return map;
    }
	
	@PutMapping(value = "/customers")
	@ApiOperation(notes="num에 해당하는 Customer 객체를 수정 합니다.", value="Customer 객체 수정")
	public Map<String, String> modify(@RequestBody Customer c) throws Exception {
        int x = service.modify(c);
        
        Map<String, String> map = new HashMap<>();
        if(x >= 1) map.put("result", "modify success!");
        else map.put("result", "modify fail!");
        return map;
    }
	
	@DeleteMapping(value = "/customers/{num}")
	@ApiOperation(notes="num에 해당하는 Customer 객체를 삭제 합니다.", value="Customer 객체 삭제")
    public Map<String, String> delete(@PathVariable String num) throws Exception {
        int x = service.delete(num);
        
        Map<String, String> map = new HashMap<>();
        if(x >= 1) map.put("result", "delete success!");
        else map.put("result", "delete fail!");
        return map;
    }
	
	@GetMapping(value = "/customers/find/{address}")
	@ApiOperation(notes="address에 해당하는 Customer 객체를 조회 합니다.", value="Customer 객체 조회")
	public List<Customer> findByAddress(@PathVariable String address) throws Exception{
		return service.findByAddress(address);
	}
	
	@PostMapping(value = "/customers/aa")
	@ApiOperation(notes="Customer 객체를 추가 합니다.", value="Customer 객체 등록")
    public Map<String, String> insert2(@RequestBody Car c) throws Exception {
		int x = 0;
		
        Map<String, String> map = new HashMap<>();
        if(x >= 1) map.put("result", "insert success!");
        else map.put("result", "insert fail!");
        return map;
    }
}
