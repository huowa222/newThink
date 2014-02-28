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
		var content = document.getElementById("content").value;
		if (content == null || content == "" || content == 'undefined') {
			alert("please fullfill the content");
			return;
		}
		document.getElementById('newThinkManageForm').submit();
	}
</script>

</head>
<body>
	<a href="newThinkManage.action?m=list&newIdeaid=${element.newIdeaid }">newThinklist</a>

	<div class="table-list">
		<fieldset>
			<legend>内容管理</legend>
			<form action="newThinkManage.action?m=save&n=${elementName }"
				method="post" id="newThinkManageForm">
				<input type="hidden" name="id" value="${element.id }" /> <input
					type="hidden" name="newIdeaid" value="${element.newIdeaid }" />
				<c:if test="${elementName eq 'objective'}">
					<input type="hidden" name="preObjId" value="${element.preObjId}" />
					<input type="hidden" name="status" value="${element.status}" />
				</c:if>
				<table border=0 cellpadding="0" cellspacing="0"
					style="word-break: break-all">

					<tr>
						<th align="left" width="150">修改内容</th>
						<td align="left" width="500"><input type="text"
							name="content" id="content" value="${element.content }">
							* </input></td>
					</tr>

					<tr>
						<td colspan="2" align="center"><a href="#"
							onclick="submitForm()">提交</a></td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>

</body>
</html>