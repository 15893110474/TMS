<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>旅游管理系统-个人中心</title>
	<script src="js/jquery.js"></script>
	<link type="text/css" rel="styleSheet"  href="css/subject.css" />
	<link type="text/css" rel="styleSheet"  href="css/list.css" />
	<style type="text/css">
		*{
			margin:0;
			padding:0;
			text-decoration:none;
			list-style:none;
		}
		li span{
			color:#FFF;
			font-size:13px;
			display:block;
		}
		li span:hover{
			color:#ccc;
		}
		.wrap{
			/* margin:60px auto; */
			width:470px;
			height:100%;
			background-color: #FFF;
			
		}
		.container-top{
			height:40px;
		}
		.container-bottom{
			height:523px;
			overflow-y: scroll; 
		}
		.container-top ul{
			height:40px;
		}
		.container-top ul li{
			float:left;
			width:49%;
			height:40px;
			line-height:40px;
			text-align:center;
			background-color:#000000;
		}
		.container-bottom ul{
			height:auto;
		}
		.container-bottom ul li{
			width:100%;
			height:50px;
			line-height:40px;
			text-align:left;
			background:none;
		}
		.container-bottom ul li a{
			color:#000000;
		}
		.select{
			background-image:linear-gradient(to right,dimgray,gray);
		}
		.con ul li{
			border-bottom:2px solid #000000;
		}
		.con ul li:hover {
		background-color: #CCC;
		}
		.ar:hover,.ah:hover {
			color:blue;
		}
	</style>
	<script type="text/javascript">
		//封装通过id来查找元素的函数，不需要引入jquery库;
		function $(id){
			return typeof id === "string"?document.getElementById(id):document;
		}
		
		window.onload = function(){
			//获取5个标题名;
			var items = $("list").getElementsByTagName("li");
			//获取5个内容盒子;
			var	divs = $("item").getElementsByTagName("div");
			if(items.length != divs.length){
				return;
			}
			
			//循环遍历标题名和内容盒子;
			for(var i = 0,len = items.length; i < len; i++){
				items[i].id = i;
				items[i].onmouseover = function(){
					for(var j = 0,len = items.length; j < len; j++){
						items[j].className = "";
						divs[j].style.display = "none";
					}
					this.className = "select";	
					divs[this.id].style.display = "block";
				}
			}
		}
	</script>
</head>
<body>
	<div class = "main">
		<!-- 系统名，标志 -->
		<div class = "logo">
			<a href="/TMS/list?page=1">旅游管理系统</a>
		</div>
		<div class="user_center" Style="float: right; margin-right: 50px">
			<%
			Cookie[] cookie = request.getCookies();//获取的是请求里的所有cookie组成的数组
			String uname = null;
			Boolean admin = false;
			if (cookie != null){
			for(int i=0;i<cookie.length;i++){
			    if ("admin".equals(cookie[i].getName())){
			    	admin = true;
			    }	
			    if("username".equals(cookie[i].getName())){
			    	uname = cookie[i].getValue();
			        
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
		<div class="left" style="background-color: #000000;border:2px solid;border-color:#89C8F5;height:600px;">
			<div class="title">
				个人中心
			</div>
			<div class="wrap">
				<div class="container-top" id="list">
					<ul>
						<li><span>我的评论</span></li>
						<li><span>宾馆信息</span></li>
						<!-- <li><span>人员信息</span></li> -->
					</ul>
				</div>
				<div class="container-bottom" id="item">
					<div class="con">
						<ul>
						<c:forEach var="bean" items="${clist}">
						<li>
							<a href="detailSS?mainId=1">
								<span style="color:#000000;text-align: left;font-size:16px;margin-left:20px;display:inline-block;">${bean.content }</span>
								<span style="color:#000000;float: right;font-size:16px;margin-right:20px;display:inline-block;">${bean.dateStr }</span>
							</a>
						</li>
						</c:forEach>
						</ul>
					</div>
					<div class="con">
						<ul>
						<%
							if(!admin){
						%>
						<li>
						<a href="detailSS?mainId=1">
								<span style="color:red;text-align: center;font-size:16px;margin-left:100px;display:inline-block;">您不是管理员，没有添加过宾馆！</span>
							</a>
						</li>
						<%} %>
						<c:forEach var="bean" items="${slist }">
							<li>
							<span style="color:#000000;text-align: left;font-size:16px;margin-left:20px;display:inline-block;"><a href="detailSS?mainId=${bean.id }">${bean.name }</a></span>
							<span style="color:#000000;float: right;font-size:16px;margin-right:20px;display:inline-block;">
							<a class="ar" href="addRestaurant.jsp?sid=${bean.id }">添加饭馆</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a class="ah" href="addHotel.jsp?sid=${bean.id }">添加宾馆</a>
							</span>
							</li>
						</c:forEach>
						</ul>
					</div>
					<!-- <div class="con">
						<ul>
							<li><a href="#">交流A</a></li>
							<li><a href="#">交流B</a></li>
							<li><a href="#">交流C</a></li>
							<li><a href="#">交流D</a></li>
						</ul>
					</div> -->
				</div>
			</div>
		</div>
		<div class="right" style="background-color: #CCC;border:2px solid;border-color:#89C8F5;">
			<div class="title">
				会员信息
			</div>
			<div style="background-color:#FFF;text-align: left">
				<ul >
						<li><span style="color:#000000;height:30px;margin-left:50px;font-size:18px">我的昵称:&nbsp;&nbsp;${person.name }</span></li>
						<li><span style="color:#000000;height:30px;margin-left:50px;font-size:18px">我的账号:&nbsp;&nbsp;${person.username }</span></li>
						<li><span style="color:#000000;height:30px;margin-left:50px;font-size:18px">我的密码:&nbsp;&nbsp;${person.password }</span></li>
						<li><span style="color:#000000;height:30px;margin-left:50px;font-size:18px">我的年龄:&nbsp;&nbsp;${person.age }岁</span></li>
						<li><span style="color:#000000;height:30px;margin-left:50px;font-size:18px">我的电话:&nbsp;&nbsp;${person.phone }</span></li>
						<li><span style="color:#000000;height:30px;margin-left:50px;font-size:18px">我的性别:&nbsp;&nbsp;${person.sex }</span></li>
				</ul>
			</div>
		</div>		
	</div>
</body>
</html>