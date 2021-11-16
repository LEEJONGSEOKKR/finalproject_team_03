package com.projectfinal.stock.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.projectfinal.stock.vo.Board;
import com.projectfinal.stock.vo.File;

@Mapper
@Repository
public interface BoardDAO {

	List<Board> boardList() throws DataAccessException;

	void boardWrite0(Board articleNO, List<MultipartFile> fileUpload) throws DataAccessException;
	
	void boardWrite(Board b) throws DataAccessException;

	List<Board> boardList1() throws DataAccessException;
	
	List<Board> boardList2over(int pageNo) throws DataAccessException;
	
	void insertFile(File File) throws DataAccessException;
	
	List<File> getFiles(int articleNO) throws DataAccessException;
}
