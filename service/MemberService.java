package com.projectfinal.stock.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectfinal.stock.dao.MemberDao;
import com.projectfinal.stock.vo.Member;

@Service
public class MemberService {

	@Autowired
	MemberDao memberDao;
	
	public void memberInsert(Member member) throws Exception {
//		System.out.println("멤버서비스?");
		memberDao.memberInsert(member);
		// TODO Auto-generated method stub
		
	}

	public List<Member> memberData(String userid) throws Exception {
		return memberDao.memberData(userid);
		
	}

	public void memberUpdate(Member member) throws Exception {
		System.out.println("멤버서비스");
		System.out.println(member);
		// TODO Auto-generated method stub
		memberDao.memberUpdate(member);
		
	}

	public void memberDel(String userid) throws Exception{
		// TODO Auto-generated method stub
		System.out.println(userid+"임");
		memberDao.memberDel(userid);
	}

	public String memberLogin(Member member) {
		// TODO Auto-generated method stub
		return memberDao.memberLogin(member);
		
	}



}
