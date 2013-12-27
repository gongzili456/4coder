<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="ctx"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>蛋疼的程序员-社区</title>
<link href="${ctx}/resources/css/bootstrap.min.css" type="text/css"
	rel="stylesheet" />
<link href="${ctx}/resources/css/bootstrap-theme.min.css"
	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/signin.css" type="text/css"
	rel="stylesheet" />
<script src="${ctx}/resources/js/jquery-1.8.3.min.js"></script>
<script src="${ctx}/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<form class="form-signin" action="loginProccess" method="post">
			<h2 class="form-signin-heading">
				登陆or<a href="register">注册</a>
			</h2>
			<input type="text" class="form-control" placeholder="Email address"
				name="email" required autofocus> <input type="password"
				name="password" class="form-control" placeholder="Password" required>

			<c:if test="${rs==0}"></c:if>
			<label class="checkbox"> <input type="checkbox"
				value="remember-me"> Remember me
			</label>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Login
			</button>
		</form>
	</div>
</body>
</html>