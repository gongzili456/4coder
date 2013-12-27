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
<link href="${ctx}/resources/css/bootstrap-theme.min.css" type="text/css"
	rel="stylesheet" />
<link href="${ctx}/resources/css/navbar-fixed-top.css"
	type="text/css" rel="stylesheet" />
<script src="${ctx}/resources/js/jquery-1.8.3.min.js"></script>
<script src="${ctx}/resources/js/bootstrap.min.js"></script>
<script src="${ctx}/resources/js/home.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
	
		var topics = ${topics};
		var html = [];
		$.each(topics, function(i,t){
				var img = "";
				var text = "";
			$.each($.parseJSON(t.topic.topicContent),function(index,topic){
				
				if(topic.type == '1'){
				
					img = topic.content;
					img = ['<img src="resources/image/',img,'" alt="图片">'].join('');
				} else {
					text = topic.content;	
				}
			});
				var div = ['<div class="col-sm-6 col-md-8">',
							'<div class="thumbnail">',
							

							
'<div class="media">',
'  <a class="pull-left" href="#">',
'    <img class="media-object" src="http://www.qiushibaike.com/static/images/thumb/missing.png" alt="头像">',
'  </a>',
'  <div class="media-body">',
'    <h6 class="media-heading">',t.user.userName,'</h6>',
'  </div>',
'</div>',
							'<div class="caption">',
							
							
							'<p>',text,'</p>',
							
							
					
							
							
							'</div>',
							img,
							'<div style="float: right;"><div  style="float: right;">',
							
							'<input type="hidden" name="topicId" value="',t.topic.topicId,'" />',
'<button type="button" class="btn btn-default btn-sm" id="favour">',
  '<span class="glyphicon glyphicon-thumbs-up"></span>',t.topic.favourCount,
'</button>',
'<button type="button" class="btn btn-default btn-sm" id="hate">',
  '<span class="glyphicon glyphicon-thumbs-down"></span>',t.topic.hateCount,
'</button>',
'<button type="button" class="btn btn-default btn-sm" id="share">',
  '<span class="glyphicon glyphicon-share-alt"></span> ',t.topic.shareCount,
'</button>',
'<button type="button" class="btn btn-default btn-sm" id="comment">',
  '<span class="glyphicon glyphicon-comment"></span>  ',t.topic.commentCount,
'</button>',
'</div></div>',		
							'</div>',
							
							'</div>'];
						html.push(div.join(''));	
		});
		$('.row').html(html.join(''));
	});
</script>
</head>
<body>

	<!-- Fixed navbar -->
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">蛋疼的程序员</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">首页</a></li>
					<li><a href="#about">最新</a></li>
					<li><a href="#contact">最热</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <s:user>
								<s:principal />
							</s:user> <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="publishPage">发帖</a></li>
							<li class="divider"></li>
							<li><a href="#">登出</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>


	<div class="container">

		<!-- Main component for a primary marketing message or call to action -->


		<div class="row">
		</div>



	</div>
	<!-- /container -->



</body>
</html>
