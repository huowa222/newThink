<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/newThink/css/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/newThink/css/themes/icon.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>header</title>

<script type=text/javascript>
	function exit(url) {
		if (confirm('登出以后下次就必须重新登录，是否登出? ')) {
			window.location = url;
		}
	}
</script>
<!--<script type="text/javascript"
	src="http://localhost:8080/newThink/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready( 
					function() {
						                        $.ajax({
														url : 'user.action?m=client'
																+ thinkId,
														dataType : 'json',
														success : function(data) {
															$("#userid").text(data);
														},
														error : function(jqXHR,
																textStatus,
																errorThrown) {
															alert("error");
														}
													});
											
										});

</script>

-->
</head>
<body>
	<div region="north" border="true" split="true"
		style="height: 35px; background: #99CCFF">
		<div>
			<span> <a href="userThink.action?m=list" plain="true">想法管理</a>
				<a href="userFriend.action?m=list" plain="true">分享平台</a> </span><span><a
				href="dataTransmit.jsp" plain="true">数据迁移 </a> </span><span> <a
				href="user.action?m=modify&userId=${newThink.userId}&newIdeaid=${newThink.id}"
				align="left">账户管理</a>
			</span><span> <a href="javascript:exit('user.action?m=exit')"
				plain="true">退出</a> </span> <span>欢迎光临: ${newThink.userid} </span>

		</div>
	</div>
</body>
</html>