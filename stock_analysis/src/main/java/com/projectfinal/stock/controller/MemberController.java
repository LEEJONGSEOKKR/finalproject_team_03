package com.projectfinal.stock.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectfinal.stock.service.MemberService;
import com.projectfinal.stock.vo.Member;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	//로그인
	@PostMapping("login")
	public String login(@ModelAttribute Member m, HttpSession session, HttpServletResponse response) {
		System.out.println("로그인시 할당 받은 세션 ID" + session.getId());
		
	  Cookie c = new Cookie("JSESSIONID", session.getId());
	  response.addCookie(c);
		   
		
		JSONObject json = new JSONObject();		
		try {
		System.out.println(m);
		String name = memberService.login(m);
		
		
		if(name!=null) {//login_ok
			m.setName(name);
			session.setAttribute("m", m);
			json.put("name",name);	
			
		 }else {
			json.put("errMsg", "로그인 오류");
		 }
		}catch(Exception e) {
			json.put("errMsg", "로그인 오류");
		}
		
		
		return json.toJSONString();
		
	}
	
	//로그아웃
	@PostMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout ok";
	}
	
	//회원가입
	@PostMapping("memberInsert")
	public String memberInsert(@ModelAttribute Member m) {
		
		System.out.println(m);
		
		try {
			memberService.memberInsert(m);
			return "회원 가입 완료 <button onclick ='window.close()' >닫기</button>" ;
		} catch (Exception e) {
			e.printStackTrace();
			return "회원 가입 실패 : ID 확인하세요";
		}
		
		
	}
	


}
