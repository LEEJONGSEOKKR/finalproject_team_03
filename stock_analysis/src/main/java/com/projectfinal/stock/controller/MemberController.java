package com.projectfinal.stock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectfinal.stock.service.MemberService;
import com.projectfinal.stock.vo.Member;

@RestController
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@PostMapping("login")
	public String login(@ModelAttribute Member m) {
		System.out.println(m);
		
		try {
			String name = memberService.login(m);
			m.setName(name);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  "환영" ;
	}
	
	@RequestMapping("memberInsert")
	public String memberInsert(HttpServletRequest request) {
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		System.out.println(id+":"+pw+":"+name);
		
		Member m = new Member(id, pw, name);
		System.out.println(m);
		
		try {
			memberService.memberInsert(m);
			return "완료";
		} catch (Exception e) {
			e.printStackTrace();
			return "가입 실패";
		}
	}
	


}
