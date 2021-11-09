package com.projectfinal.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectfinal.stock.service.MemberService;
import com.projectfinal.stock.vo.Member;

@RestController
//S@CrossOrigin(origins="http://localhost:3000",allowCredentials="true")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@PostMapping("/memberInsert")
	public String memberInsert(@ModelAttribute Member member) {
		System.out.println(member);

		try{
			memberService.memberInsert(member);
			System.out.println("잉 야긴가");
			return "회원가입 성공";
		}catch(Exception e) {
			
			return "회원가입 실패: 다시확인해주세요.";
		}
	}
}
