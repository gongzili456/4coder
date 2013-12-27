<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="ctx"></c:set>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>蛋疼的程序员--社区</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="${ctx}/resources/css/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/resources/css/flat-ui.css" rel="stylesheet" />
<style type="text/css">
body {
	padding-top: 70px;
}

.navbar {
	border-radius: 0px;
}
</style>
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
    <![endif]-->
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Project name</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">最新</a></li>
					<li><a href="#about">最热</a></li>
					<li><a href="#contact">真相</a></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">
						<s:user>
							${user.userName}
							</s:user> <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="publishPage">发帖</a></li>
							<li><a href="#">设置</a></li>
							<li class="divider"></li>
							<li><a href="loginout">退出</a></li>
						</ul></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">
		<div class="row"></div>
	</div>


	<!-- Load JS here for greater good =============================-->
	<script src="${ctx}/resources/js/jquery-1.8.3.min.js"></script>
	<script src="${ctx}/resources/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="${ctx}/resources/js/jquery.ui.touch-punch.min.js"></script>
	<script src="${ctx}/resources/js/bootstrap.min.js"></script>
	<script src="${ctx}/resources/js/bootstrap-select.js"></script>
	<script src="${ctx}/resources/js/bootstrap-switch.js"></script>
	<script src="${ctx}/resources/js/flatui-checkbox.js"></script>
	<script src="${ctx}/resources/js/flatui-radio.js"></script>
	<script src="${ctx}/resources/js/jquery.tagsinput.js"></script>
	<script src="${ctx}/resources/js/jquery.placeholder.js"></script>
	<script src="${ctx}/resources/js/home.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			home_content.init(${topics});
		});
	</script>
</body>
</body>
</html>
