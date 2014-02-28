<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/newThink/css/css2.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>dataTransmit page</title>

<script type="text/javascript" src="http://localhost:8080/newThink/js/jquery-1.4.2.min.js"></script>
<script>
	function submitForm() {
		var content = document.getElementById("content").value;
		if (content == null || content == "" || content == 'undefined') {
			alert("are you sure to start transmit the data? ");
			return;
		}
		document.getElementById('newThinkManageForm').submit();
	}
</script>

</head>
<body border="1">
	</br>
	<div class="table-list">
		<fieldset>
			<legend>用户数据管理</legend>
			<form action="transmition.action?m=start"
				method="post" id="newThinkManageForm">
				<table border=0 cellpadding="0" cellspacing="0"
					style="word-break: break-all">
					<tr>
						<td colspan="2" align="center"><a href="#"
							onclick="submitForm()">开始数据迁移</a></td>
					</tr>
					<tr>
					</tr>
					<tr>
						<td colspan="2" align="center"><a href="#"
							onclick="submitForm()">停止数据迁移</a></td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
</body>
</html>
</body>
</html>