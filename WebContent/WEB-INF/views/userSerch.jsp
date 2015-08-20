<%@page import="kr.co.syncbook.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//	BoardUserDAO dao = new BoardUserDAOImpl();
//	List<UserVO> list = dao.getUserList();

	List<MemberVO> list =(List<MemberVO>) request.getAttribute("UserList");
%>
	<form action="">
	아이디 입력:
		<input type="text">
		<input type="submit" value="Serch">
	</form>
	
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th> 
			<th>이메일</th> 
			<th>전화번호</th> 
			<th>주소</th> 
			<th>상세주소</th> 
			<th>우편번호</th>
			<th>가입날짜</th>  
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<%if(list != null){
			for(MemberVO member : list){
		%>		
		<tr>
			<td><%=member.getId() %></td>
			<td><%=member.getPassword()%></td>
			<td><%=member.getName()%></td>
			<td><%=member.getEmail() %></td>
			<td><%=member.getPhone() %></td>
			<td><%=member.getAddress() %></td>
			<td><%=member.getDetail_address() %></td>
			<td><%=member.getPost() %></td>
			<td><%=member.getReg_date() %></td>
			<td><a href = "updateForm.jsp?id=<%=member.getId() %>">수정</a></td>
			<td><a href = "userDel.jsp?id=<%=member.getId() %>">삭제</a></td>
		</tr>
<%}} %>
	</table>

</body>
</html>