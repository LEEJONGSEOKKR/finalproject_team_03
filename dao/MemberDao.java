package com.projectfinal.stock.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.projectfinal.stock.vo.Member;

@Mapper
@Repository
public interface MemberDao {

	public void memberInsert(Member member) throws DataAccessException;
	
}