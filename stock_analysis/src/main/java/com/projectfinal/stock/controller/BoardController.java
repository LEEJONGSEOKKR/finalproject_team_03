package com.projectfinal.stock.controller;
 
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projectfinal.stock.service.BoardService;
import com.projectfinal.stock.vo.Board;
import com.projectfinal.stock.vo.Member;
  
@Controller
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true") 
public class BoardController {
		 
	@Autowired
	BoardService boardService;

	
   	@GetMapping("/boardList")
	@ResponseBody
	public String boardList() {
	    
		List<Board> list=boardService.boardList();		
		JSONArray arr=new JSONArray();
		for(Board b:list) {
			
			JSONObject o=new JSONObject();
			o.put("articleNo", b.getArticleNO());
			o.put("title", b.getTitle());
			o.put("content", b.getContent());
			o.put("id", b.getId());
			o.put("parentNo", b.getParentNO());
			o.put("writeDate", b.getWriteDate().toString());
			o.put("level", b.getLevel());
			arr.add(o);
		}
		System.out.println(arr);
		return arr.toJSONString();
	}
	
	@GetMapping("/boardList2")
	@ResponseBody
	public String boardList2() {
	        
		List<Board> list=boardService.boardList();		
		JSONArray arr=new JSONArray();
		for(Board b:list) {
			
			JSONObject o=new JSONObject();
			o.put("articleNo", b.getArticleNO());
			o.put("title", b.getTitle());
			o.put("content", b.getContent());
			o.put("id", b.getId());
			o.put("parentNo", b.getParentNO());
			o.put("writeDate", b.getWriteDate().toString());
			o.put("level", b.getLevel());
			arr.add(o);
		}
		System.out.println(arr);
		return arr.toJSONString();
	}
	
	
	   @PostMapping("/boardWrite")
	   public String boardWrite(@ModelAttribute Board b, HttpSession session, HttpServletResponse response) {
		   
		   System.out.println("새글 쓰고 요청시 세션 ID" + session.getId());
		   
		   Member m = (Member)session.getAttribute("m");
		   System.out.println(m);
		   if(m==null) {
			   return "로그인부터 하세요";
		   }else {
			   b.setId(m.getId());
			   if(b.getArticleNO()>0) {
				  b.setParentNO(b.getArticleNO());
				  b.setArticleNO(0);
			   }
			   System.out.println(b);
			   try {
				   boardService.boardWrite(b);
				   
				   
			   }catch(Exception e) {
				   e.printStackTrace();
				   return "글 등록 실패";
			   }
			   return "글 등록 됨";
		   }

		   
	   }
	   
	   @ResponseBody
		@PostMapping("/boardwrite0")
		public String write(Board article, @RequestPart("fileUpload") List<MultipartFile> fileUpload) throws Exception {
//		   Member m = (Member)session.getAttribute("m");
//		   article.setId(m.getId());
			System.out.println(article);
			System.out.println(fileUpload);
			boardService.boardWrite0(article, fileUpload);
		      return "파일등록완료용~";
		   }
	   
	   
//		@GetMapping("/download")
//		@ResponseBody
//		public FileSystemResource download(@RequestParam("savedFileName") String savedFileName, HttpServletResponse res) {
//			return boardService.download(savedFileName,res);
//			
//		}
	   
	   
	


}