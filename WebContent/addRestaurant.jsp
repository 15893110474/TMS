<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>旅游管理系统-添加饭馆</title>
	<script src="js/jquery.js"></script>
	<link type="text/css" rel="styleSheet"  href="css/subject.css" />
	<link type="text/css" rel="styleSheet"  href="css/add.css" />
	<style type="text/css">
		td{
			height:40px;
		}
		
		tr{
			border:1px solid #a8aeb2;
		}

   		.tit{
   			width:399px;
			text-align: right;
			
   		}
   		
   		.input{
   			text-align: left;
   		}
	</style>
</head>
<body>
	<div class="main">
		<!-- 系统名，标志 -->
		<div class = "logo">
			<a href="/TMS/list?page=1">旅游管理系统</a>
		</div>
		<div class="user_center" Style="float: right; margin-right: 50px">
		<%
			Cookie[] cookie = request.getCookies();//获取的是请求里的所有cookie组成的数组
			Boolean ret = false;
			String uname = null;
			if (cookie != null){
			for(int i=0;i<cookie.length;i++){
			    if("username".equals(cookie[i].getName())){
			    	ret = true;
			    	uname = cookie[i].getValue();
			        //System.out.println(cookie[i].getValue() + "666");//得到peter
			        break;
			    }
			}
			}
			if (uname!=null && !uname.equals("")){ %>
			<a href="../TMS/person"><%=uname %></a>
			<span>&nbsp;&nbsp;</span>
			<a href="loginOut" style="color: red;font-size: 11px">退出登录</a>			
			<%} else { %>
			<a href="login.jsp">登录</a>
			<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<a href="regist.jsp">注册</a>
			<a></a>
			<%} %>
		</div>
		<br/>
		<div class="info">
			<div class="box">
				<div class="search">
					<div class="box_top"><b class="pl15" style="font-family: 楷体">添加新饭馆</b></div>
					<div class="box_center">
						<form action="newSR" method="post" enctype="multipart/form-data">
							<span>&nbsp;</span>
							<div class="add">
								<div class="add_center" >
									<div class="add_main center">
										<%
										String sid = "1";
										request.setCharacterEncoding("UTF-8");
										if (request.getParameter("sid") != null){
											sid = request.getParameter("sid");
										}
										if (sid != null && !sid.equals("")){
										%>
										<input type="hidden" name="SId" value="<%=sid %>"  />
										<%} %>				
										<div class="username">饭馆名称：<input class="shurukuang" type="text" name="name" size="20" placeholder="限制15字" maxlength="15"></div>
										<div class="username">消费 / 元：<input class="shurukuang" type="text" name="consumption" size="20" oninput = "value=value.replace(/[^\d]/g,'')" maxlength="4" placeholder="请输入该饭馆的平均消费"></div>
										<div class="username">详细地址：<input class="shurukuang" type="text" name="address" size="20" placeholder="限制30字" maxlength="30"></div>
										<div class="username">饭馆介绍：<textarea class=""  name="introduce" placeholder="请简单介绍该饭馆"></textarea></div>
										<div class="username">饭馆图片：<input class="image" type="file" name="imgUrl" onchange="preview(this)"><span id="preview"><img class="updateImg" style="display: none;" id="imgHidden" /></span></div>
									</div>
									<div class="login_submit">
										<input class="submit" type="submit" name="submit" value="保存" >
									</div>
									<%if (request.getAttribute("msg") != null){ %>
									<div><span style="color:red;font-size:14px;text-align: center;"><%=request.getAttribute("msg") %></span></div>
									<%}%>
								</div>
							</div>
						</form>
					</div></div></div></div>
	</div>
</body>
<script type="text/javascript">
$(function(){
	$("#to_index").click(function(){
		window.location.href="index.jsp";
	})
})
//图片回显:
function preview(file) {
　　$("#imgHidden").css("display", "none");
　　var prevDiv = document.getElementById('preview');
　　if (file.files && file.files[0]) {
　　　　var reader = new FileReader();
　　　　reader.onload = function(evt) {
　　　　　　prevDiv.innerHTML = '<img class="updateImg" src="' + evt.target.result + '" />';
　　　　}
　　　　reader.readAsDataURL(file.files[0]);
　　} else {
　　　　prevDiv.innerHTML = '<div class="img" style="width: 100px;height:100px;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + 
file.value + '\'"></div>';
　　}
}

function preview2(file) {
　　$("#imgHidden2").css("display", "none");
　　var prevDiv = document.getElementById('preview2');
　　if (file.files && file.files[0]) {
　　　　var reader = new FileReader();
　　　　reader.onload = function(evt) {
　　　　　　prevDiv.innerHTML = '<img class="updateImg" src="' + evt.target.result + '" />';
　　　　}
　　　　reader.readAsDataURL(file.files[0]);
　　} else {
　　　　prevDiv.innerHTML = '<div class="img" style="width: 100px;height:100px;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + 
file.value + '\'"></div>';
　　}
}

</script>
</html>