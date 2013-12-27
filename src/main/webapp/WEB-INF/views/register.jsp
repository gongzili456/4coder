<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>欢迎注册</h1>
	<form action="registerProccess" method="post">
		email:<input type="text" name="email"><br> name:<input
			type="text" name="name"><br> pass:<input type="password"
			name="pass"><br> <input type="submit" value="submit">
	</form>
</body>
</html>