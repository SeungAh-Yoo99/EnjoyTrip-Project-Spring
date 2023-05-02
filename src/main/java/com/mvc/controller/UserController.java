package com.mvc.controller;

import com.mvc.service.UserService;
import com.mvc.vo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
	
	@Autowired
    UserService service;

    @PostMapping(value = "/user/join")
    @ApiOperation(notes="회원가입", value="User 객체 등록")
    public Map<String, String> join(@RequestBody User user) throws Exception {
        int x = service.join(user);

        Map<String, String> map = new HashMap<>();
        if(x >= 1) map.put("result", "join success!");
        else map.put("result", "join fail!");
        return map;
    }

    @PutMapping(value = "/user/modify")
    @ApiOperation(notes="회원 정보 수정", value="User 객체 수정")
    public Map<String, String> modify(HttpSession session) throws Exception {
        int x = service.modify((User)session.getAttribute("user"));

        Map<String, String> map = new HashMap<>();
        if(x >= 1) map.put("result", "modify success!");
        else map.put("result", "modify fail!");
        return map;
    }

    @GetMapping(value = "/user/{id}")
    @ApiOperation(notes="회원 정보 조회", value="User 객체 조회")
    public User search(@PathVariable String id, HttpSession session) throws Exception {
    	User sessionUser = (User)session.getAttribute("user");
    	if(sessionUser.getId().equals(id) || sessionUser.getRole().equals("admin")) return service.search(id);
    	else throw new Exception();
    }

    @DeleteMapping(value = "/user/{id}")
    @ApiOperation(notes="회원 탈퇴", value="User 객체 삭제")
    public Map<String, String> withdraw(@PathVariable String id, HttpSession session) throws Exception {
    	User sessionUser = (User)session.getAttribute("user");
    	if(!sessionUser.getId().equals(id) && !sessionUser.getRole().equals("admin")) throw new Exception();
    	
        int x = service.withdraw(id);

        Map<String, String> map = new HashMap<>();
        if(x >= 1) map.put("result", "withdraw success!");
        else map.put("result", "withdraw fail!");
        return map;
    }

	@GetMapping(value = "/user/login")
	@ApiOperation(notes="로그인", value="로그인")
	public Map<String, String> login(@RequestBody User user, HttpSession session) throws Exception{
        User u = service.login(user);

        Map<String, String> map = new HashMap<>();
        if(u == null) {
            map.put("result", "login fail!");
            return map;
        }

        session.setAttribute("user", u);
        map.put("result", "login success");
        return map;
	}

    @GetMapping(value = "/user/logout")
    @ApiOperation(notes="로그아웃", value="로그아웃")
    public Map<String, String> logout (HttpSession session) throws Exception{
        session.invalidate();

        Map<String, String> map = new HashMap<>();
        map.put("result", "logout success");
        return map;
    }

    @GetMapping(value = "/user/findPw")
    @ApiOperation(notes="비밀번호 찾기", value="비밀번호 찾기")
    public Map<String, String> findPw (@RequestBody Map<String, String> rb, HttpSession session) throws Exception{
    	User sessionUser = (User)session.getAttribute("user");
    	
        User user = service.search(sessionUser.getId());
        user.setPw(rb.get("pw"));
        int x = service.newPw(user);

        Map<String, String> map = new HashMap<>();
        if(x >= 1) map.put("result", "findPw success!");
        else map.put("result", "findPw fail!");
        return map;
    }
}
