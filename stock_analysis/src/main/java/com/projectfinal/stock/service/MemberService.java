package com.projectfinal.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectfinal.stock.dao.MemberDAO;
import com.projectfinal.stock.vo.Member;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberDAO;

	public void memberInsert(Member m) throws Exception{
	      memberDAO.memberInsert(m);
	      
	   }

	   public String login(Member m) throws Exception{      
	      return memberDAO.login(m);
	   }
	
	

}
