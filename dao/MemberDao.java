package com.projectfinal.stock.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.projectfinal.stock.vo.Member;

@Mapper
@Repository
public interface MemberDao {

	public void memberInsert(Member member) throws DataAccessException;

	public List<Member> memberData(String userid)throws DataAccessException;

	public void memberUpdate(Member member) throws DataAccessException;

	public void memberDel(String userid) throws DataAccessException;

	public String memberLogin(Member member) throws DataAccessException;
	
}