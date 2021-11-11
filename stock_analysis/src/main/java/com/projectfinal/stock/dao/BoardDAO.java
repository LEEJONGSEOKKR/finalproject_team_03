package com.projectfinal.stock.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.projectfinal.stock.vo.Board;

@Mapper
@Repository
public interface BoardDAO {

	List<Board> boardList() throws DataAccessException;

//	void boardWrite(Board b) throws DataAccessException;
//	
//	List<Board> boardList1() throws DataAccessException;
//	
//	List<Board> boardList2over(int pageNo) throws DataAccessException;

}
