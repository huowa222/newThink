<%@include file="../header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
function submitForm() {
	var friendId = document.getElementById("friendId").value;	
	var userid = document.getElementById("userid").value;
	if (friendId == null || friendId == "" || friendId == 'undefined'||friendId=='0') {
		alert("please input your friendId");
		return;
	} 
	document.getElementById('userFriendForm').submit();
}
</script>

<title>friend manage</title>
</head>
<body>
<div id="1" class="table-list">
		<fieldset>
			<legend>添加朋友</legend>
			<form action="userFriend.action?m=save" method="post"
				id="userFriendForm">
				<input type="hidden" name="userid" id ="userid" value="${userFriendVo.userid }" />
				<table border=0 cellpadding="0" cellspacing="0"
					style="word-break: break-all">
					<tr>
						<th align="left" width="150">朋友Id</th>
						<td align="left" width="500"><input type="text"
							name="friendId" id="friendId" value="${userFriendVo.friendId }">
							* </input>
						</td>
					</tr>
					
					<tr>
						<td colspan="2" align="center"><a href="#"
							onclick="submitForm()">提交</a>
						</td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
</body>
</html>