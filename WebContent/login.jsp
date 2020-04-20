<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
/* Cookie[] cookie = request.getCookies();//获取的是请求里的所有cookie组成的数组
for(int i=0;i<cookie.length;i++){
    if("username".equals(cookie[i].getName())){
        //System.out.println(cookie[i].getValue());//得到peter
        break;
    }
} */

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>旅游管理系统-用户登录</title>
	<script src="js/jquery.js"></script>
	<link type="text/css" rel="styleSheet"  href="css/subject.css" />
	<link rel="stylesheet" type="text/css" href="css/login.css">

</head>
<body>
	<div class = "main" style="height: 600px;">
		<!-- 系统名，标志 -->
		<div class = "logo">
			<a href="/TMS/list?page=1">旅游管理系统</a>
		</div>
		<br/>
		<!-- 用户登录 -->
		<div class="login1">
			<form action="login" method="post">
				<span>&nbsp;</span>
				<div class="login">
					<div class="login_center" >
						<div class="login_top">
							<div class="left fl"><span style="margin-left: -100px">会员登录</span></div>
							<div class="right fr"><span style="margin-left: -40px">您还不是我们的会员？<a href="regist.jsp" target="_self">立即注册</a></span></div>
							<div class="clear"></div>
							<div class="xian center"></div>
						</div>
						<div class="login_main center">
							<div class="username">用户名:&nbsp;<input class="shurukuang" type="text" name="username" id="username" placeholder="请输入你的用户名"/></div>
							<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input class="shurukuang" type="password" name="password" id="password" placeholder="请输入你的密码"/></div>
						</div>
						<div class="login_submit">
							<input class="submit" id="login" type="submit" name="submit" value="立即登录" >
							<%
							String msg = (String)request.getAttribute("msg");
							if (msg!=null && !msg.equals("")){
							%>
							<br>
							<span style="text-align: center;margin-left:40px;font-size:18px;color:red"><%=msg %></span>
							<%} %>						
						</div>
					</div>
				</div>
		</form>
		</div>		
	</div>
<%
 String info = null;
 if (request.getAttribute("info") != null){
	 info = request.getAttribute("info").toString();
 }
%>
<script type="text/javascript">
/* $("#login").click(function(){
	var uname = $("#username").val();
	alert(uname);
	var pwd = $("#password").val();
	if (uname.length <= 0 || pwd.length <=0){
	alert("用户名或密码不能为空");
}) */
window.onload=function(){
	var inf = <%=request.getAttribute("info")%>;
	/* alert("123"); */
	if (inf !=null){
		alert(inf);
	}
	
}
</script>
</body>
</html>