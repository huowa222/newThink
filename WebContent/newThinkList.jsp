<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>userThink show</title>

<style type="text/css">
ul {
	list-style: none;
	magin: 0;
	padding: 0;
	text-align: right;
}

li {
	list-style: none;
	magin: 0;
	padding: 0;
	text-align: right;
}
</style>
<script type="text/javascript"
	src="http://localhost:8080/newThink/js/jquery-1.4.2.min.js"></script>

<script>
	var isDrag = 0;//是否可拖动标志，可拖动为1，不可拖动为2  
	var divAndMouseX;//鼠标落点距离div左上角x坐标的差距  
	var divAndMouseY;//鼠标落点距离div左上角y坐标的差距  
	var divMove;
	var x;
	var y;
	var thinkId;

	//鼠标按下时  
	function down(div) {//鼠标按下  
		isDrag = 1;//将div设置为可拖动  
		thinkId = div.getAttribute("id");//记录想法Id
		divMove = div;//用于下边拖动时的定位(新的位置的坐标)  
		//首先计算鼠标与拖动对象左上角的坐标差，然后在下边拖动方法中，用鼠标的坐标减坐标差就是新位置的坐标了  
		divAndMouseX = event.clientX - parseInt(div.style.left);
		divAndMouseY = event.clientY - parseInt(div.style.top);
	}
	function move() {//拖动过程计算div坐标  
		if (isDrag == 1) {
			divMove.style.left = event.clientX - divAndMouseX;
			divMove.style.top = event.clientY - divAndMouseY;
			x = divMove.style.left;
			y = divMove.style.top;
		}
	}

	function up(event) {//放开鼠标将div设置为不可拖动  

		isDrag = 0;
		$.ajax({
			url : 'userThink.action?m=changePosition&thinkId=' + thinkId
					+ '&x=' + divMove.style.left + '&y=' + divMove.style.top,
			type : 'POST',
			dataType : 'json',
			data : 'x=' + divMove.style.left + '&y=' + divMove.style.top
					+ 'thinkId=' + thinkId,
			success : function(data) {
				//if (equals(data, "success"))
				//alert("成功修改位置");
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("错误");
			}
		});

	}
	function deleteConfirm(url) {
		if (confirm(' are you sure to delete it? ')) {
			window.location = url;
		}
	}
</script>

</head>
<body>
	<br>
	<p>
		<font size="10" colour=black face="Times"> What to do: </font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a
			id="addtype" href="userThink.action?m=add&userId=${userId }">newThinking...</a>
	</p>

	<div class="table-list">
		<c:forEach items="${ThinkList}" var="newThink">
			<div id=${newThink.id } onmousedown="down(this)" onmousemove="move()"
				onmouseup="up()"
				style="cursor: move; border: 1px dashed blue; background-color: ${newThink.color}; width: auto; height: auto; position: absolute; left: ${newThink.position_x }px; top: ${newThink.position_y }px;">
				<table>
					<tr style="width: 100%">
						<td><img src="uploads/${newThink.picUrl }" height="80px"
							width="70px">
						</td>
						<td align="left"><a
							href="newThinkManage.action?m=list&userId=${newThink.userId}&newIdeaid=${newThink.id}">${newThink.content
								}</a></td>
						<td align="left">
							<ul align="right">
								<li><a
									href="javascript:deleteConfirm('userThink.action?m=delete&userId=${newThink.userId}&id=${newThink.id}')"}><img
										src="img/delete.jpg" width="20px" height="20px"> </a>
								</li>
								<c:choose>
									<c:when test="${newThink.isPost eq '1' }">
										<li><a
											href="userThink.action?m=post&userId=${newThink.userId}&id=${newThink.id}&isPost=${newThink.isPost}">取消发布</a>
									</c:when>
									<c:otherwise>
										<li><a
											href="userThink.action?m=post&userId=${newThink.userId}&id=${newThink.id}&isPost=${newThink.isPost}">发布</a>
									</c:otherwise>
								</c:choose>
								</li>
								<!--<li><a
									href="userThink.action?m=modify&userId=${newThink.userId}&id=${newThink.id}">修改</a>
								</li>
								-->
							</ul>
						</td>
					</tr>
				</table>
			</div>

		</c:forEach>
	</div>
</body>
</html>