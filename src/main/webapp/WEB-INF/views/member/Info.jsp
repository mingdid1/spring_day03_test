<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	개인정보<br><br>
	
	id : ${ dto.id }<br>
	pwd : ${ dto.pwd }<br>
	name : ${ dto.name }<br>
	
	<a href="list">목록이동</a>
</body>
</html>