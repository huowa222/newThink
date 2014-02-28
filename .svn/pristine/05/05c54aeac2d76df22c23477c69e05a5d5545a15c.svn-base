<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/newThink/css/css2.css" />
<style type="text/css">
.panel {
	margin: 0px;
	padding: 5px;
	text-align: left;
	background: #e5eecc;
	border: solid 1px #c3c3c3;
	height: auto;
	width: 35%;
	display: none;
	align: left;
}

#friendList {
	position: absolute;
	left: 20px;
	width: 200px;
	top: 60px;
	border: solid 1px;
}

#friendThink {
	position: absolute;
	right: 20px;
	top: 60px;
	width: 500px;
	border: solid 1px;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>FriendThink show</title>

<script type="text/javascript">
	function deleteConfirm(url) {
		if (confirm(' are you sure to delete it? ')) {
			window.location = url;
		}
	}
</script>

<script type="text/javascript"
	src="http://localhost:8080/newThink/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$(".comment")
								.click(
										function() {
											var thinkId = $(this).attr("id");
											var _thinkId = "#_" + thinkId;
											var postUserId = $(this).attr(
													"postUserId");
											//var _thinkId = "#" + thinkId;
											$(_thinkId).html("");
											$
													.ajax({
														url : 'userThinkAndComment.action?m=comment&thinkId='
																+ thinkId,
														dataType : 'json',
														success : function(data) {
															$(_thinkId)
																	.append(
																			"<input type='text' name='content' id='content' thinkId="+thinkId+" postUserId="+postUserId+" />");
															$(_thinkId)
																	.append(
																			"<button id='addComment'>评论</button>");
															$(_thinkId)
																	.append(
																			"<ul id ='commentTop'>");
															for ( var i = 0; i < data.length; i++) {
																var content = data[i].content;
																var commentUserid = data[i].userid;

																$(_thinkId)
																		.append(
																				"<li style='background: lightblue; margin: 3px'>"
																						+ commentUserid
																						+ " 评论"
																						+ postUserId
																						+ ' : '
																						+ content
																						+ "</li>");
															}
															$(_thinkId).append(
																	"</ul>");
														},
														error : function(jqXHR,
																textStatus,
																errorThrown) {
															alert("error");
														}
													});
											$(_thinkId).slideToggle("slow");
										});

						$("#addComment")
								.live(
										'click',
										function() {
											var thinkId = $("#content").attr(
													"thinkId");
											var postUserId = $("#content")
													.attr("postUserId");
											var content = $("#content").val();
											$
													.ajax({
														url : 'userThinkAndComment.action?m=addComment',																
														type : 'POST',
														dataType : 'json',
														data : 'newThinkId='
																+ thinkId
																+ '&content='
																+ content
																+ '&postUserId='
																+ postUserId,
														success : function(data) {
															alert("评论成功");
															//$(".panel").prepend("<ul><li><div><span>评论"+postUserId+' : '+content+"</span></div></li></ul>");
															$(
																	"<li style='background: lightblue;'>"
																			+ data
																			+ "评论"
																			+ postUserId
																			+ ' : '
																			+ content
																			+ "</li>")
																	.insertAfter(
																			"#commentTop");
														},
														error : function(jqXHR,
																textStatus,
																errorThrown) {
															alert("错误");
														}
													});
										});
					});
</script>

</head>
<body>
	<a href="userFriend.action?m=add">添加朋友Id</a>
	<div>
		<table class="table-list" style="margin: 5px;">
			<thead>
				<tr>
					<th field="name1" align="left" width="80%"><b>朋友列表</b></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userFriendList}" var="friend">
					<tr>
						<td>${friend.friendId }</td>
						<td align="right"><a
							href="javascript:deleteConfirm('userFriend.action?m=delete&id=${friend.id}')"}>刪除</a>
						</td>
					</tr>
				</c:forEach>
		</table>
	</div>


	<div style="margin: 5px;">
		<table class="table-list">
			<thead>
				<tr>
					<th field="name1" align="left" width="80%"><b>朋友想法</b></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><ul>
							<c:forEach items="${userFriendThinkList}" var="friend">
								<li><ul>
										<c:forEach items="${friend }" var="friendThink">
											<li>
												<table width="500px">
													<tr style="background: lightblue;">
														<td width="10%">${friendThink.userId }</td>
														<td width="80%">${friendThink.content }</td>
														<td width="10%"><button id=${friendThink.id }
																class="comment" postUserId=${friendThink.userId }>评论</button>
														</td>
													</tr>
												</table>
											</li>
											<li id="_${friendThink.id }"><div class="panel"></div></li>
										</c:forEach>
									</ul>
								</li>
							</c:forEach>
						</ul></td>

				</tr>

			</tbody>
		</table>
	</div>

</body>
</html>