<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>uploadPics page</title>

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
				document.getElementById('1').innerHTML = xmlhttp.responseText;
			} else {
				alert("Problem retrieving data:" + xmlhttp.statusText);
			}
		}
	}
</script>
</head>
<body>
	<div>
		<form name="thinkPics" action="userThink.action?m=uploadPics"
			method="post" enctype="multipart/form-data">
			<input type="file" name="pics" size="50" /> <!--<input type="submit"
				value="提交" />
		--><button onclick="loadXMLDoc('userThink.action?m=uploadPics')">上传</button>
		</form>
	</div>

	<div id="1">uuu</div>
</body>
</html>