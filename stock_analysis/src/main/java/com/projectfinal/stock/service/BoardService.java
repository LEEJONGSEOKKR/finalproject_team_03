package com.projectfinal.stock.service;

import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.projectfinal.stock.common.FileSaverHelper;
import com.projectfinal.stock.dao.BoardDAO;
import com.projectfinal.stock.vo.Board;
import com.projectfinal.stock.vo.File;

@Service
public class BoardService {
	
	@Resource(name="saveDir") //@리소스는 이름으로 찾아서 DI해줌
	private String saveDir;

	
	@Autowired
	private FileSaverHelper fileSaveHelper;
	
	@Autowired
	BoardDAO boardDAO;
	
	public List<Board> boardList(){
		return boardDAO.boardList();
	}
	
	public List<Board> boardList(int pageNo){

			return boardDAO.boardList2over(pageNo);
	}

	
	public void boardWrite(Board b) throws Exception {
		boardDAO.boardWrite(b);
		
	}

	public FileSystemResource download(String savedFileName, HttpServletResponse res) {
		res.setContentType("application/download");
		String originalFileName=savedFileName.substring(savedFileName.indexOf("_")+1);
		try {
			originalFileName = URLEncoder.encode(originalFileName, "utf-8").replace("+", "%20").
					replace("%28", "(").replace("%29",")");
		}catch(Exception e) {
		}
		
		res.setHeader("Content-Disposition", "attachment;" +" filename=\""+originalFileName+"\";");
		FileSystemResource fsr= new FileSystemResource(saveDir+savedFileName);
		return fsr;
	}
	
	public List<File> getFiles(int articleNo) {
		return boardDAO.getFiles(articleNo);
	}

	public void boardWrite0(Board article, List<MultipartFile> fileUpload) {
//		if(fileUpload.size()!=0){// 오류
//		if(!fileUpload.isEmpty()){// 오류
//			System.out.println("파일 있음");
//		}
//		List<MultipartFile>는 CommonsMultipartFile을 리턴함
		// 그래서 isEmpty()(List에 있는 isEmpty()메소드임)로 물어보면 List 값이
		// 비어있는 것이 아님
		// MultipartFile에 있는 isEmpty()를 사용해야함
		System.out.println("글쓰기 전의 articleNum "+article.getArticleNO());
		boardDAO.boardWrite(article);
		System.out.println("글쓰기 후의 articleNum "+article.getArticleNO());
		
		if(!fileUpload.get(0).isEmpty()) {
			for(MultipartFile mf:fileUpload) {
				String savedFileName=fileSaveHelper.save(mf);
				File fileDto = new File();
				fileDto.setOriginalFileName(mf.getOriginalFilename());
				fileDto.setSavedFileName(savedFileName);
				fileDto.setArticleNO(article.getArticleNO());
				boardDAO.insertFile(fileDto);
			}
		}
		// TODO Auto-generated method stub
		
	}
	
}

