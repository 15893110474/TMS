<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>旅游管理系统-景区详情</title>
	<script src="js/jquery.js"></script>
	<link type="text/css" rel="styleSheet"  href="css/subject.css" />
	<link type="text/css" rel="styleSheet"  href="css/list.css" />
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
		<div class="" style="background-color: #CCC;border:2px solid;border-color:#89C8F5">
			<div class="title">
				宾馆详情
			</div>
		<div class="article-content" style="color: #000000;">
			<p style="text-align: center;">
				<span >宾馆名称：</span><span class="bjh-p"><a href="https://hotel.bestwehotel.com/" target="_blank">${hotel.name }</a></span><br><br>
				<span >房间类型：</span><span class="bjh-p">${hotel.type }</span><br><br>
				<span >平均消费：</span><span class="bjh-p">${hotel.price }元</span><br><br>
				<span >详细地址：</span><span class="bjh-p">${hotel.address }</span><br><br>
				<span class="bjh-p"></span>
			</p>
			
			<div class="img-container">
				<img class="large" src="./img/${hotel.imgUrl }">
			</div>
			<p><span class="bjh-p">${hotel.introduce }</span></p>
		</div>
		</div>
	</div>
</body>
</html>