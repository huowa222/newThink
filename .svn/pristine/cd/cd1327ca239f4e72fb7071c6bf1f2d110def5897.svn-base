<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/newThink/css/css.css" />
<script language ="javascript">
function registerForm(){
	var user = document.getElementById("userid").value;
	var password =document.getElementById("password").value;   
	if(user==null||user==""){
		alert("请输入用户名");
		return ;
	}
	else if(password==null||password=="")
		{
		alert("请输入密码");
		return ;
		}
		document.getElementById('registerForm').submit();
}
</script>


<title>register page</title>
</head>
<body>
<form  action="user.action?m=register" method="post" id ="registerForm">
  	<fieldset>
    	<div class="table-list">
      	<label for="logName">账　号</label>
      	<div class="frmC">
        	<i class="txt"><input type="text" class="" name="userid" id="userid"></i>
        </div>
      </div>
      <div class="table-list">
      	<label for="passWord">密　码</label>
      	<div class="frmC">
        	<i class="txt"><input type="password" name="password" id="password"></i>
        </div>
      </div>
      
      <!--  <div class="frm frmSubmit">
      	<div class="frmC">
        	<input type="submit" class="submit" value="注册">
        </div>
      </div> -->
     
         <tr><td colspan="2" align="center">
				<a href="#" onclick="registerForm()">提交</a>  
		  </td>
	  </tr>  
     
    </fieldset>
  </form>

</body>
</html>