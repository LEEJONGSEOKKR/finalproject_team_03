package com.projectfinal.stock.controller;
 
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectfinal.stock.service.BoardService;
import com.projectfinal.stock.vo.Board;
import com.projectfinal.stock.vo.Member;
  
@Controller
public class BoardController {
	
	 
	@Autowired
	BoardService boardService;
	
	@GetMapping("/boardList")
	public String boardList(Model model) {
		List<Board> list = boardService.boardList();
		model.addAttribute("articlesList", list);
		return "boardList";
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
	
//  @GetMapping("/boardList")
//  public String boardList(Model model) {
//     List<Board> list=boardService.boardList();
//     model.addAttribute("articlesList", list);
//     return "test";
//  }
   

   
//   @PostMapping("/boardWrite")
//   @ResponseBody
//   public String boardWrite(HttpServletRequest request) {
//      String title=request.getParameter("title");
//      String content=request.getParameter("content");
//      Board b=new Board(title, content);
//      System.out.println(b);
//      return "test ok";
//   }
   
//   @PostMapping("/boardWrite")
//   @ResponseBody
//   public String boardWrite(@ModelAttribute Board b, HttpSession session, HttpServletResponse response) {
//	   
//	   System.out.println("새글 쓰고 요청시 세션 ID" + session.getId());
//	   
////	   Cookie c = new Cookie("JSESSIONID", session.getId());
////	   response.addCookie(c);
//	   
//	   Member m = (Member)session.getAttribute("m");
//	   System.out.println(m);
//	   if(m==null) {
//		   return "로그인부터 하세요";
//	   }else {
//		   b.setId(m.getId());
//		   if(b.getArticleNO()>0) {
//			  b.setParentNO(b.getArticleNO());
//			  b.setArticleNO(0);
//		   }
//		   System.out.println(b);
//		   try {
//			   boardService.boardWrite(b);//이건 스프링툴슈트 버그인듯==>실행에는 상관없음
//			   
//			   
//		   }catch(Exception e) {
//			   e.printStackTrace();
//			   return "글 등록 실패";
//		   }
//		   return "글 등록 됨";
//	   }
//
//   }
//
//
//   

   


}