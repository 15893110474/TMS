<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>旅游管理系统-新用户注册</title>
	<script src="js/jquery.js"></script>
	<link type="text/css" rel="styleSheet"  href="css/subject.css" />
	<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<div class = "main">
		<!-- 系统名，标志 -->
		<div class = "logo">
			<a href="/TMS/list?page=1">旅游管理系统</a>
		</div>
		<br/>
	<div>
		<form  method="post" action="add">
		<div class="regist">
			<div class="regist_center">
				<div class="regist_top">
					<div class="left fl"><span style="margin-left: 20px">会员注册</span></div>
					<div class="right fr"><a href="./login.jsp" target="_self"><span style="margin-right: 40px;font-size: 18px">返回登录</span></a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="regist_main center">
					<div style="margin-left: -32px" class="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;<input class="shurukuang" name="username" id="username" type="text" maxlength="12" placeholder="请输入用户名（账号）" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')"/><span style="margin-left: 8px">请不要输入汉字</span></div>
					<div style="margin-left: -12px" class="username">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="shurukuang" name="password" id="password" type="password" name="password" placeholder="请输入你的密码" maxlength="12"/><span style="margin-left: 8px">请输入6位以上字符</span></div>
					<div style="margin-left: 13px" class="username">确认密码:&nbsp;&nbsp;<input class="shurukuang"name="password2" id="password2" type="password" name="repassword" placeholder="请确认你的密码" maxlength="12"/><span style="margin-left: 8px">两次密码要输入一致哦</span></div><!--  οnkeyup="pwdCheck()" -->
					<div style="margin-left: 60px" class="username">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:&nbsp;&nbsp;<input class="shurukuang" type="text" name="name" maxlength="6" placeholder="请输入你的昵称"/><span style="margin-left: 8px">请输入汉字、字母、或者数字</span></div>
					<div style="margin-left: -34px" class="">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" class="shurukuang" value="男" checked="true" />男<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <input type="radio" name="sex" class="shurukuang" value="女"/>女<span style="margin-left: 88px">请选择你的性别</span></div>
					<div style="margin-left: 45px" class="username">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:&nbsp;&nbsp;<input class="shurukuang" type="text" name="age" id="age" placeholder="请输入你的年龄" maxlength="2" onkeyup="this.value=this.value.replace(/\D/g,'')"><span style="margin-left:8px">请输入年龄，只能输入数字</span></div>
					<div style="margin-left: 108px" class="username">手&nbsp;&nbsp;机&nbsp;&nbsp;号:&nbsp;&nbsp;<input class="shurukuang" type="text" name="phone" id="phone" maxlength="11" placeholder="请填写正确的手机号" onkeyup="this.value=this.value.replace(/\D/g,'')"/><span style="margin-left: 8px">填写下手机号吧，方便我们联系您！</span></div>
				<div class="regist_submit">
					<input class="submit" type="submit" name="submit" id="regist" value="立即注册" >
					<%
					String msg = (String)request.getAttribute("msg");
					if (msg!=null && !msg.equals("")){
					%>
					<span style="text-align: center;font-size:18px;color:red"><%=msg %></span>
					<%} %>
				</div>

				<!-- 
				<input class="shurukuang" name="sex" id="sex" type="text" placeholder="请输入或选择你的性别" maxlength="1" list="sexlist"><span style="margin-left: 8px">请输入或者选择你的性别</span>
            		<datalist id="sexlist"><option>男</option><option>女</option></datalist>
				 -->
			</div>
		</div>
		</form>	
	</div>
	</div>
	<script type="text/javascript">
	window.onload=function(){
		$('#password').bind('input propertychange',function(){pwdCheck();});
		$('#password2').bind('input propertychange',function(){pwdCheck();});
		
	}
	
	/* function pwdCheck(){
		alert("zhixing");
		var a = $("#password").val();
		alert(a);
		var b = $("#password2").val();
		alert(b);
		if (a!=b){
			$("#regist").attr("disabled","disabled");
			alert("两次输入密码不一致");
		}
	} */
	
	</script>
	
</body>
</html>