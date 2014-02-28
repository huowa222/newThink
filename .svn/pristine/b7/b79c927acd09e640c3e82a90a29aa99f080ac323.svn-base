<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>newThinkEdit page</title>

<script type="text/javascript">
	var xmlhttp;
	function loadXMLDoc(url) {
		xmlhttp = null;
		if (window.XMLHttpRequest) {// code for Firefox, Opera, IE7, etc.
			xmlhttp = new XMLHttpRequest();
		} else if (window.ActiveXObject) {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlhttp != null) {
			xmlhttp.onreadystatechange = state_Change;
			xmlhttp.open("POST", url, true);
			xmlhttp.send(null);
		} else {
			alert("Your browser does not support XMLHTTP.");
		}
	}

	function state_Change() {
		if (xmlhttp.readyState == 4) {// 4 = "loaded"
			if (xmlhttp.status == 200) {// 200 = "OK"
				document.getElementById('picUrl').innerHTML = xmlhttp.responseText;
			} else {
				alert("Problem retrieving data:" + xmlhttp.statusText);
			}
		}
	}

	function submitForm() {
		var content2 = document.getElementById("content2").value;
		var picUrl = document.getElementById("picUrl").value;
		var color = document.userThinkForm.color.value;

		if (picUrl == null || picUrl == "" || picUrl == 'undefined') {
			alert("please upload pics for your new think");
			return;
		} else if (content2 == null || content2 == ""
				|| content2 == 'undefined') {
			alert("please input your new idea");
			return;
		}
		//else if(color == null || color == "" || color == 'undefined')
		//{
		//alert("please select your background color");
		//return;
		//}
		document.getElementById('userThinkForm').submit();
	}

	function changePic() {
		var MsgStyle = document.getElementById("2").style;
		var picUrl = document.getElementById("picUrl").value;
		if (picUrl == null || picUrl == "" || picUrl == 'undefined') {
			MsgStyle.display = "block";
		} else {
			MsgStyle.display = "none";
		}
	}
</script>
</head>
<body onload="changePic()">

	<div id="2" class="table-list">
		<fieldset>
			<legend>上传想法图片</legend>
			<form name="thinkPics" action="userThink.action?m=uploadPics"
				method="post" enctype="multipart/form-data">
				<input type="file" name="pics" size="50" /> <input type="hidden"
					name="id" value="${userThink.id }" /> <input type="hidden"
					name="userId" value="${userThink.userId }" /> <input type="hidden"
					name="content" id="content1" value="${userThink.content }">
				<input type="hidden" name="isPost" value="${userThink.isPost }" />
				<input type="hidden" name="position_x"
					value="${userThink.position_x }" /> <input type="hidden"
					name="position_y" value="${userThink.position_y }" /> </input> <input
					type="submit" value="上传" />
				<!--
				<button onclick="loadXMLDoc('userThink.action?m=uploadPics')">上传</button>-->
			</form>
		</fieldset>
	</div>

	<div id="1" class="table-list">
		<fieldset>
			<legend>想法描述</legend>
			<form action="userThink.action?m=save" method="post"
				id="userThinkForm" name="userThinkForm">
				<input type="hidden" name="id" value="${userThink.id }" /> <input
					type="hidden" name="picUrl" id="picUrl"
					value="${userThink.picUrl }" /> <input type="hidden" name="userId"
					value="${userThink.userId }" /> <input type="hidden" name="isPost"
					value="${userThink.isPost }" /> <input type="hidden" name="color"
					value="${userThink.color }" /> <input type="hidden"
					name="position_x" value="${userThink.position_x }" /> <input
					type="hidden" name="position_y" value="${userThink.position_y }" />
				</input>
				<table border=0 cellpadding="0" cellspacing="0"
					style="word-break: break-all">

					<tr>
						<th align="left" width="150">想法描述</th>
						<td align="left" width="500"><input type="text"
							name="content" id="content2" value="${userThink.content }">
							</input></td>
					</tr>
					<tr>
						<th align="left" width="150">选择颜色</th>
						<td><select name="color" id="color">
								<option value="lightblue">浅蓝</option>
								<option value="#ff7575"
									<c:if test="${userThink.color eq '#ff7575' }"> selected="selected"</c:if>>浅红</option>
								<option value="#F9F900"
									<c:if test="${userThink.color eq '#F9F900' }"> selected="selected"</c:if>>浅橙</option>
								<option value="#FFFF93"
									<c:if test="${userThink.color eq '#FFFF93' }"> selected="selected"</c:if>>浅黄</option>
								<option value="#79FF79"
									<c:if test="${userThink.color eq '#79FF79' }"> selected="selected"</c:if>>浅绿</option>
								<option value="#97CBFF"
									<c:if test="${userThink.color eq '#97CBFF' }"> selected="selected"</c:if>>浅蓝</option>
								<option value="#B8B8DC"
									<c:if test="${userThink.color eq '#B8B8DC' }"> selected="selected"</c:if>>浅靛</option>
								<option value="#D2A2CC"
									<c:if test="${userThink.color eq '#D2A2CC' }"> selected="selected"</c:if>>浅紫</option>
						</select></td>
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