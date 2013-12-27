<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>发帖</title>
<script type="text/javascript"
	src="resources/js/jquery-1.8.3.min.js">
</script>
<script type="text/javascript">

	$(document).ready(function(){
		var topics = ${topics};
		var html = [];
		$.each(topics, function(i,t){
			$.each($.parseJSON(t.topicContent),function(index,topic){
				if(topic.type == '1'){
					var url = 'http://dantengcoder.eicp.net/d/'+topic.content;
					html.push(['<img width="200px;" height="200px;" src="',url,'">'].join(''));
				} else {
					html.push(topic.content);	
				}
			});
		});
		$('body').html(html.join(''));
	});
</script>
</head>
<body>
</body>
</html>