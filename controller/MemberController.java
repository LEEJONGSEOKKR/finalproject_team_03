package com.projectfinal.stock.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectfinal.stock.service.MemberService;
import com.projectfinal.stock.vo.Member;

@RestController
@CrossOrigin(origins="http://localhost:3000",allowCredentials="true")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	//회원가입
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
	
	//회원정보수정 (이름 이메일 패스워드)
	@PostMapping("/memberUpdate")
	public String memberUpdata(@ModelAttribute Member member) {
		System.out.println(member);
		
		try {
			memberService.memberUpdate(member);
			System.out.println("클리어");
		} catch (Exception e) {
			return "다시 시도해주세요";
		}
		
		return "회원정보 수정완료";
	}
	 
	//회원정보보기(아이디값 입력 받기)
	@PostMapping("/memberView")
	public String memberView(HttpServletRequest id) throws Exception{
		String userid = id.getParameter("userid");
		System.out.println(userid);
		List<Member> memberdata = memberService.memberData(userid);

		System.out.println(memberdata);
		JSONArray json=new JSONArray();
		System.out.println(memberdata);
		for(Member member:memberdata) {
			JSONObject oj=new JSONObject();
			oj.put("username", member.getUsername());
			oj.put("userid", member.getUserid());
			oj.put("userpassword", member.getUserpassword());
			oj.put("useremail", member.getUseremail());
			oj.put("userage", member.getUserage());
			oj.put("usergender", member.getUsergender());
			oj.put("usergrade", member.getUsergrade());
			json.add(oj);
		}
		System.out.println(json);
		return json.toJSONString();	
	}
	
	//회원탈퇴
	@GetMapping("/memberDel")
	public void memberDel(HttpServletRequest id) throws Exception {
		String userid = id.getParameter("userid");
		System.out.println(userid);
		memberService.memberDel(userid);
		System.out.println("삭제완료");
		
	}
	
	//로그인
	@PostMapping("/memberLogin")
	public String memberLogin(@ModelAttribute Member member) {
		
		return memberService.memberLogin(member);
	}
}

