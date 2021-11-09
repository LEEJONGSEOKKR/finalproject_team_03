package com.projectfinal.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectfinal.stock.dao.MemberDao;
import com.projectfinal.stock.vo.Member;

@Service
public class MemberService {

	@Autowired
	MemberDao memberDao;
	
	public void memberInsert(Member member) throws Exception {
		System.out.println("멤버서비스?");
		memberDao.memberInsert(member);
		// TODO Auto-generated method stub
		
	}

}
