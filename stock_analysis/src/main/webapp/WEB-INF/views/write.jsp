<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="/fullstack/write.bbs" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${id}">
		<table class="table">
			<tr>
				<td>글쓴이 :</td>
				<td>${id}</td> 
			</tr>
			<tr>
			 <td>제목 :</td>
			 <td><input type = "text" name="title"></td>
			</tr>
			<tr>
			 <td colspan="2">
			 	<textarea name="content" rows="10" cols="60"></textarea>
			 </td>
			 </tr>
			 <tr>
			  <td colspan="2">
			  	<input type="file" name="fileUpload" multiple="multiple" value="파일을 선택하세요">
			  	<!-- 멀티플은 여러가지 선택가능하게 -->
			  </td>
			  </tr>
			  <tr>
			   <td><input type="submit" value="글쓰기"></td>
			   <td><input type="reset" value="취소"></td>
			   </tr>
		</table>
 </form>
 <body>
</html>