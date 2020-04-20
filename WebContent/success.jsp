<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>旅游管理系统-添加成功</title>
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
					<div class="box_top"><b class="pl15" style="font-family: 楷体 ;color:red;"><%=request.getAttribute("msg")==null ? "景点添加成功！！！" : request.getAttribute("msg") %></b></div>
					<div class="box_center">
						<div style="margin-top:30px;">
						<%
							int sid = 1;
							if (request.getAttribute("sid") != null){
								sid = (Integer) request.getAttribute("sid");
							} else {
								if (request.getParameter("sid") != null){
									sid = Integer.parseInt(request.getParameter("sid"));
								}
							}
							
						%>
							<a id="addRestaurant" href="addRestaurant.jsp?sid=<%=sid %>">添加饭馆</a>
							<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
							<a id="addHotel" href="addHotel.jsp?sid=<%=sid %>">添加宾馆</a>
									</div>
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