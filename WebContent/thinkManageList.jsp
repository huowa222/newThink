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
<title>newThinkManage page</title>

<style type="text/css">
#newInspiration {
	position: relative;
	bottom: 0px;
	height: 30px;
}
</style>

<script type="text/javascript"
	src="http://localhost:8080/newThink/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$(".newInspiration")
								.click(
										function() {
											var newIdeaid = $(this).attr("id");
											var content = $(
													"#newInspirationText")
													.val();
											$
													.ajax({
														url : 'newThinkManage.action?m=add_ajax',	
														type : 'POST',							
														dataType : 'json',
														data : 'newIdeaid='
															+ newIdeaid
															+ '&content='
															+ content,
														success : function(data) {
															$(
																	"#newInspirationListContent")
																	.html("");

															for ( var i = 0; i < data.length; i++) {
																var content = data[i].content;
																var id = data[i].id;
																var thinkId = data[i].newIdeaid;

																$(
																		"#newInspirationListContent")
																		.append(
																				"<tr class='inspiration'><td>"
																						+
																						"<a href='newThinkManage.action?m=modify&n=inspiration&id="
																						+ id
																						+ "&newIdeaid="
																						+ thinkId
																						+ "'>"
																						+ content
																						+ "</a>");
																$(
																		"#newInspirationListContent")
																		.append(
																				"<a href='javascript:deleteConfirm1"
																						+ "('newThinkManage.action?m=delete&n=inspiration&id="
																						+ id
																						+ "&newIdeaid="
																						+ thinkId
																						+ "') >删</a></td></tr>");
															}
														},
														error : function(jqXHR,
																textStatus,
																errorThrown) {
															alert("error");
														}
													});
										});

						$("#anotationContent")
								.keyup(
										function(keyEvent) {
											var keyCode = keyEvent.keyCode;
											if (keyCode == 13) {
												var preContent = $(this).val();
												var content = $.trim(preContent);		
												var newIdeaid = $(this).attr(
														"newIdeaid");
												var id = $(this).attr(
														"anotationId");
												$
														.ajax({
															url : 'newThinkManage.action?m=modify_ajax',
															type : 'POST',
															dataType : 'json',
															data : 'newIdeaid='
																+ newIdeaid
																+ '&content='
																+ content
																+ '&id='
																+ id,
															success : function(
																	data) {
																$(
																		"#anotationContent")
																		.val(
																				content);
															},
															error : function(
																	jqXHR,
																	textStatus,
																	errorThrown) {
																alert("error");
															}
														});
											}
											;
										});

						$(".inspiration").live('mousemove', function() {
							$(this).css("background-color", "#D6D6FF");
						});
						$(".inspiration").live('mouseout', function() {
							$(this).css("background-color", "");
						});

						$(".addInspiration").live('mousemove', function() {
							$(this).css("background-color", "");
						});
						$(".addInspiration").live('mouseout', function() {
							$(this).css("background-color", "#D6D6FF");
						});
						$("#flag").click(function() {
							var flag="";
							var a = $("#flag").checked;
							var newIdeaid = ${newIdeaid};
							if($("#flag").attr("checked"))
								flag = "true1";
							window.location="newThinkManage.action?m=list&newIdeaid="+newIdeaid+"&flag="+flag;
						});
					});

	function selectedShowObj(url) {	
			window.location = url;

	}
	function deleteConfirm1(url) {
		if (confirm(' are you sure to delete it? ')) {
			window.location = url;
		}
	}
	function deleteConfirm2(url) {
		if (confirm(' are you sure to delete it? ')) {
			window.location = url;
		}
	}
	function deleteConfirm3(url) {
		if (confirm(' are you sure to delete it? ')) {
			window.location = url;
		}
	}
</script>

</head>
<body border="1">

	</br>
	<table>
		<tr>
			<td style="width:600px;"><div width="100%" align="left">
					<img alt="" src="uploads/${picUrl }" height="80px" width="70px">
					<font size="4" color=black face="Times"> Want to do: </font><font
						size="7" color=black face="Times">${newThinkName }</font>
				</div></td>
			<td></div>
				<div width="100%" align="left">
					<font size="7" color="lightred" face="Times"> 目标完成
						：${objProcessNo }</font>
				</div></td>
		</tr>
	</table>

	<hr/>

	<div id="objectiveList" class="table-list">

		<table id="newObjectiveList" class="table-list" border="1"
			style="width: 100%;">
			<thead>
				<tr>
					<th field="name1" width="70%" height="30px" align="left"
						bgcolor="#D6D6FF"><b>行动计划 &nbsp&nbsp&nbsp&nbsp</b>
						<c:choose>
						<c:when test="${flag eq 'true1'}">
						<input type="checkbox" name="flag" id="flag" newIdeaid="newIdeaid" checked="checked"></input>
						</c:when>
						<c:otherwise>
						<input type="checkbox" name="flag" id="flag" newIdeaid="newIdeaid"></input>
						</c:otherwise>
						</c:choose>
						<label>显示已完成目标</label>
					</th>
					<th field="name2" width="20%" height="30px" align="right"
						bgcolor="#D6D6FF"><b><a
							href="newThinkManage.action?m=add&n=objective&newIdeaid=${newIdeaid}&preObjId=${preObjId}">创建新目标
						</a> </b>
					</th>
				</tr>

			</thead>
			<tbody>
				<c:forEach items="${newObjectiveVoList}" var="newObjective">

					<tr>

						<td>
						<c:if test=""></c:if>
						<c:choose>
								<c:when test="${newObjective.status eq 'true1'}">
									<table bgcolor="green" width="100%">
										<tr>
											<td><a
												href="newThinkManage.action?m=list&n=objective&id=${newObjective.id}&newIdeaid=${newObjective.newIdeaid}&preObjId=${newObjective.id}"><font
													color="blue">${newObjective.content }</font> </a></td>
										</tr>
									</table>
								</c:when>
								<c:otherwise>
									<table width="100%">
										<tr>
											<td><a
												href="newThinkManage.action?m=list&n=objective&id=${newObjective.id}&newIdeaid=${newObjective.newIdeaid}&preObjId=${newObjective.id}"><font
													color="blue">${newObjective.content }</font> </a></td>
										</tr>
									</table>
								</c:otherwise>
							</c:choose></td>

						<td><c:choose>
								<c:when test="${newObjective.status eq 'true1'}">
									<a
										href="newThinkManage.action?m=ObjStatus&id=${newObjective.id}&newIdeaid=${newObjective.newIdeaid}">完成</a>
								</c:when>
								<c:otherwise>
									<a
										href="newThinkManage.action?m=ObjStatus&id=${newObjective.id}&newIdeaid=${newObjective.newIdeaid}">未成</a>
								</c:otherwise>
							</c:choose><a
							href="newThinkManage.action?m=modify&n=objective&id=${newObjective.id}&newIdeaid=${newObjective.newIdeaid}">修改</a>
							<a
								href="javascript:deleteConfirm2('newThinkManage.action?m=delete&n=objective&id=${newObjective.id}&newIdeaid=${newObjective.newIdeaid}&preObjId=${newObjective.preObjId}')"}><img
									src="img/delete.jpg" width="15px" height="15px"> </a>
						</td>
					</tr>


				</c:forEach>
		</table>

	</div>
	<div id="inspirationList" class="table-list">
		<div style="height: 75%;">
			<table id="newInspirationList" class="table-list" border="1"
				style="width: 100%;">
				<thead>
					<tr>

						<th field="name1" align="left" width="80%" height="30px"
							bgcolor="#D6D6FF"><b>灵感</b>
						</th>
						<th field="name2" align="right" width="10%" height="30px"
							bgcolor="#D6D6FF"></th>
					</tr>
				</thead>
				<tbody id="newInspirationListContent">
					<c:forEach items="${newInspirationVoList}" var="newInspiration">
						<tr class="inspiration">

							<td><a
								href="newThinkManage.action?m=modify&n=inspiration&id=${newInspiration.id}&newIdeaid=${newInspiration.newIdeaid}">${newInspiration.content
									}</a></td>

							<td><a
								href="javascript:deleteConfirm1('newThinkManage.action?m=delete&n=inspiration&id=${newInspiration.id}&newIdeaid=${newInspiration.newIdeaid}')"}><img
									src="img/delete.jpg" width="15px" height="15px"> </a></td>
						</tr>
					</c:forEach>
			</table>
		</div>
		<div name="newInspiration" id="newInspiration">
			<span> <input type="text" name="newInspirationText"
				id="newInspirationText" class="addInspiration" style="background-color: #D6D6FF; height : 33px; width : 446px;"></input> </span> <span><img
				src="img/add.jpg" width="20px" height="20px" class="newInspiration"
				id=${newIdeaid } style="background-color: #D6D6FF height : 38px;"/> </span>
		</div>

	</div>
	<div id="anotation" class="table-list">
		<div style="align: left; height : 30px; background-color : #D6D6FF;">备注</div>
		<div>
			<textarea name="anotationContent" id="anotationContent" crows="80"
				cols="60" newIdeaid=${newAnotationVoList[0].newIdeaid }
				anotationId=${newAnotationVoList[0].id } style="width : 493px; height : 93px;">${newAnotationVoList[0].content }
</textarea>
		</div>
</body>
</html>
</body>
</html>