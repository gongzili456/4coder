<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="cn.gongzili.utils.PropertyUtils"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="ctx"></c:set>
<html lang="en">
<head>
<meta charset="utf-8">
<title>蛋疼的程序员--社区</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${ctx}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/resources/css/flat-ui.css" rel="stylesheet" />
<link href="${ctx}/resources/css/jquery.fileupload.css" rel="stylesheet">
<link href="${ctx}/resources/css/jquery.fileupload-ui.css"
	rel="stylesheet">
<noscript>
	<link href="${ctx}/resources/css/jquery.fileupload-noscript.css"
		rel="stylesheet">
</noscript>
<noscript>
	<link href="${ctx}/resources/css/jquery.fileupload-ui-noscript.css"
		rel="stylesheet">
</noscript>
<style type="text/css">
body {
	padding-top: 70px;
}

.navbar {
	border-radius: 0px;
}
</style>
<title>发帖</title>
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
						data-toggle="dropdown"> <s:user>
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
		<div class="row">
			<div class="col-md-9">
				<form id="fileupload" class="form-horizontal" action="publish">

					<div class="form-group">
						<label class="col-sm-2 control-label">标题:</label>
						<div class="col-sm-7">
							<input name="title" type="text" class="form-control"
								placeholder="这里输入标题...">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">正文:</label>
						<div class="col-sm-7">
							<textarea class="form-control" rows="5" name="content"
								id="contentTextarea" placeholder="这里输入内容..."></textarea>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="row fileupload-buttonbar">
								<div class="col-lg-7">
									<span class="btn btn-success btn-xs fileinput-button"> <i
										class="glyphicon glyphicon-open"></i> <span>上传图片</span> <input
										  type="file" name="files[]" multiple>
									</span>
								</div>
							</div>
				            <table class="table table-striped">
				            	<tbody class="files" id="files">
				            	</tbody>
				            </table>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" value="submit" class="btn btn-primary">
						</div>
					</div>


				</form>
			</div>
		</div>
	</div>




	<!-- <form action="publish" method="post" enctype="multipart/form-data">
	</form> -->


	
	
	
	<script src="${ctx}/resources/js/jquery-1.8.3.min.js"></script>
	<script src="${ctx}/resources/js/jquery.ui.widget.js"></script>
	<script src="http://blueimp.github.io/JavaScript-Templates/js/tmpl.min.js"></script>	
	<script src="http://blueimp.github.io/JavaScript-Load-Image/js/load-image.min.js"></script>
	<script src="http://blueimp.github.io/JavaScript-Canvas-to-Blob/js/canvas-to-blob.min.js"></script>
	<script src="${ctx}/resources/js/bootstrap.min.js"></script>
	<script src="http://blueimp.github.io/Gallery/js/jquery.blueimp-gallery.min.js"></script>
	<script src="http://blueimp.github.io/JavaScript-Templates/js/tmpl.min.js"></script>
	<script src="${ctx}/resources/js/jquery.iframe-transport.js"></script>
	<script src="${ctx}/resources/js/jquery.fileupload.js"></script>
	<script src="${ctx}/resources/js/jquery.fileupload-process.js"></script>
	<script src="${ctx}/resources/js/jquery.fileupload-image.js"></script>
	<script src="${ctx}/resources/js/jquery.fileupload-jquery-ui.js"></script>
	
	
	
	
	
	
	
	  <script type="text/javascript">
	
	
		$(function(){
			var uploadUurl = "<%=PropertyUtils.getValue(PropertyUtils.UPLOADIMAGE_SAVEPATH)%>";

			console.log($.support.cors);
			
			$('#fileupload').fileupload(
					{
						xhrFields : {
							withCredentials : false
						},
						autoUpload : false,
						url : uploadUurl,
						dataType : 'json',
						
						disableImageResize: /Android(?!.*Chrome)|Opera/
							.test(window.navigator && navigator.userAgent),
						
		                imageMaxWidth : 100,			                
		                imageMaxHeight : 100,
		                imageCrop : true,
			                
						add :function(e, data){
							/* console.log('add event:',e);
							console.log('files:',data.files);
							
							console.log('loadImage:'); */
							loadImage(e.target.files[0], function(img) {
								//document.body.appendChild(img);
								console.log('img:',img);
								$('.files').append(img);
							}, {maxWidth: 600});
						},
						change : function(e, data){
							console.log('change event:', e.target.files);
							console.log('change data:', data.files[0]);
							
							var img = loadImage(data.files[0], function(img){
								if(img.type === "error") {
						            console.log("Error loading image " + data.files[0]);
						            return null;
						        }else{
						        	return img;
						        }
							},{maxWidth: 50});
							console.log('img outHTML',img.outerHTML);
							console.log('img',img);
							var tr = ['<tr>',
		            		'<td></td>',
		            		'<td>',data.files[0].name,'</td>',
		            		'<td>',data.files[0].size,'</td>',
		            		'<td><div class="progress-bar progress-bar-success" style="width:0%;"></div></td>',
		            		'<td><button class="btn btn-primary start" disabled>',
		                    '<i class="glyphicon glyphicon-upload"></i>',
		                    '<span>Start</span>',
		                '</button>',
		                '<button class="btn btn-warning cancel">',
	                    '<i class="glyphicon glyphicon-ban-circle"></i>',
	                    '<span>Cancel</span>',
	                '</button>',
		                '</td>',
		            		'</tr>'].join('');
							console.log($(tr));
							console.log($(tr).first());
							$('.files').append($tr);
							
							
						},
						
						processQueue : [{
								action : 'load',
			                	fileTypes: /^image\/(gif|jpeg|png)$/,
			                    maxFileSize: 20000000 // 20MB	
			                },{
			                	action: 'resize',
			                    maxWidth: 1920,
			                    maxHeight: 1200,
			                    minWidth: 800,
			                    minHeight: 600
			                },
	                	],
						
						
						done : function(even, data) {
						},
						progressall : function(even, data) {
						}
					});
		});
	</script>  
</body>
</html>