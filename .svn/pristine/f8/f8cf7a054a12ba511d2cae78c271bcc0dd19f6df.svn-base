<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>dragTest</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	var isDrag = 0;//是否可拖动标志，可拖动为1，不可拖动为2  
	var divAndMouseX;//鼠标落点距离div左上角x坐标的差距  
	var divAndMouseY;//鼠标落点距离div左上角y坐标的差距  
	var divMove;
	//鼠标按下时  
	function down(div) {//鼠标按下  
		isDrag = 1;//将div设置为可拖动  
		divMove = div;//用于下边拖动时的定位(新的位置的坐标)  
		//首先计算鼠标与拖动对象左上角的坐标差，然后在下边拖动方法中，用鼠标的坐标减坐标差就是新位置的坐标了  
		divAndMouseX = event.clientX - parseInt(div.style.left);
		divAndMouseY = event.clientY - parseInt(div.style.top);
	}
	function move() {//拖动过程计算div坐标  
		if (isDrag == 1) {
			divMove.style.left = event.clientX - divAndMouseX;
			divMove.style.top = event.clientY - divAndMouseY;
		}
	}

	function up() {//放开鼠标将div设置为不可拖动  
		isDrag = 0;
	}
</script>
</head>

<body>

	<div class="table-list">
		<c:forEach items="${ThinkList}" var="newThink">
			<div id=${newThink.id } onmousedown="down(this)" onmousemove="move()"
				onmouseup="up()"
				style="cursor: move; border: 1px dashed blue; background-color: lightblue; width: 30%; height: auto; position: absolute; left: ${newThink.position_x }px; top: ${newThink.position_y }px;">
				<table>
					<tr style="width: 100%">
						<td><img src=${newThink.picUrl } height="80px" width="50px">
						</td>
						<td align="left"><a
							href="newThinkManage.action?m=list&userId=${newThink.userId}&newIdeaid=${newThink.id}">${newThink.content
								}</a></td>
						<td width="25%" align="right">
							<ul>
								<li><a
									href="userThink.action?m=post&userId=${newThink.userId}&id=${newThink.id}&isPost=${newThink.isPost}">发布</a>
								</li>
								<li><a
									href="userThink.action?m=modify&userId=${newThink.userId}&id=${newThink.id}">修改</a>
								</li>
								<li><a
									href="javascript:deleteConfirm('userThink.action?m=delete&userId=${newThink.userId}&id=${newThink.id}')"}>删除</a>
								</li>
							</ul>
						</td>
					</tr>
				</table>
			</div>

		</c:forEach>
	</div>
</body>
</html>
