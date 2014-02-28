<%@include file="../header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>thinkManageEdit page</title>

<script>
	function submitForm() {
		var userid = document.getElementById("userid").value;
		var password = document.getElementById("password").value;
		if (userid == null || userid == "" || userid == 'undefined') {
			alert("please fullfill your userid");
			return;
		}
		if (password == null || password == "" || password == 'undefined') {
			alert("please fullfill your password");
			return;
		}
		document.getElementById('userModifyForm').submit();
	}
</script>

</head>
<body>

	<div class="table-list">
		<fieldset>
			<legend>密码修改</legend>
			<form action="user.action?m=save" method="post"
				id="userModifyForm">
				<input type="hidden" name="userId" value="${userInfoVo.userId }" /> <input
					type="text" name="password" value="${userInfoVo.password }" /> <a
					href="#" onclick="submitForm()">提交</a>
				</td>
			</form>
		</fieldset>
	</div>

</body>
</html>