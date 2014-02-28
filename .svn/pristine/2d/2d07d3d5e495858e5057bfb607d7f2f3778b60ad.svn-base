<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/newThink/css/css.css" />
<title>login page</title>

<script language="javascript">
	function submitForm() {
		var user = document.getElementById("userid").value;
		var password = document.getElementById("password").value;
		if (user == null || user == "") {
			alert("请输入用户名");
			return;
		} else if (password == null || password == "") {
			alert("请输入密码");
			return;
		}
		document.getElementById('loginForm').submit();
	}
	function getCookie(searchName) {
		var cookies = document.cookie.split(";");
		for ( var i = 0; i < cookies.length; i++) {
			var cookiesCrumbs = cookies[i].split("=");
			var cookieName = cookiesCrumbs[0];
			var cookieValue = cookiesCrumbs[1];
			if (cookieName == searchName) {
				return cookieValue;
			}
		}
		return null;
	}

	function onloadCookie() {
		var userid = getCookie(" userid");
		var password = getCookie(" password");
		if (!(userid == null || userid == "")
				&& !(password == null || password == "")) {
			document.getElementById("userid").value = userid;
			document.getElementById("password").value = password;
			document.getElementById("loginForm").submit();
		}

	}
</script>

</head>
<body onload=onloadCookie()>
	<form action="user.action?m=login" method="post" id="loginForm">
		<fieldset>
			<div class="frm frmName">
				<label for="logName">账 号</label>
				<div class="frmC">
					<i class="txt"><input type="text" class="" name="userid"
						id="userid"> </i>
				</div>
			</div>
			<div class="frm frmPassword">
				<label for="passWord">密 码</label>
				<div class="frmC">
					<i class="txt"><input type="password" name="password"
						id="password"> </i>
				</div>
			</div>
			<div class="frm frmCookie">
				<label for="passWord">是否下次自动登录</label>
				<div class="frmC">
					<input type="radio" name="cookie" id="cookie1" value="yes" checked="checked">是</input> <input
						type="radio" name="cookie" id="cookie2" value="no">否</input>
				</div>
			</div>
			<tr>
				<td colspan="2" align="center" id="login"><a href="#"
					onclick="submitForm()">提交</a></td>
			</tr>

		</fieldset>
	</form>

	<th align="left">还没有注册？</th>

	<a href="register.jsp">转去注册页面</a>

</body>
</html>