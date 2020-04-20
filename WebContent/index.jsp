<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>旅游管理系统</title>
	<script src="js/jquery.js"></script>
	<link type="text/css" rel="styleSheet"  href="css/subject.css" />
	<style type="text/css">
		.list tr td{
			height:40px;
			border:1px solid #a8aeb2;
		}
	</style>
	
	<style type="text/css">
		#next,#before,#last,#first{
			font: 12px 宋体,Times New Roman;
		}
   		#next:hover,#before:hover,#last:hover,#first:hover{ 
   			color: #385f9e;
   		}
	</style>
</head>
<body>
	<div class = "main">
		<!-- 系统名，标志 -->
		<div class = "logo">
			<a href="/TMS/list?page=1">旅游管理系统</a>
		</div>
		<div class="user_center" Style="float: right; margin-right: 50px" id="user_center">
		<%
			Cookie[] cookie = request.getCookies();//获取的是请求里的所有cookie组成的数组
			Boolean ret = true;
			String uname = "";
			Boolean admin = false;
			if(cookie != null){
			for(int i=0;i<cookie.length;i++){
			    if ("admin".equals(cookie[i].getName())){
			    	admin = true;
			    }			    
				if("username".equals(cookie[i].getName())){
			    	uname = cookie[i].getValue();
			    }
			}
			}
			if (uname!=null && !uname.equals("")){ 
			%>
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
		
		<!-- 项目内容 -->
		<div class="info">
			<div class="box">
				<!-- 搜索框 -->
				<div class="search">
					<div class="box_top"><b class="pl15">搜索</b></div>
					<div class="box_center">
						<div class="mysearch">
							<form action="list" method="post">
									景点名称：
									<input class="" type="text" id="name" name="name" size="20">
									<input type="hidden" name="page" value="1"/> 
									所在城市：
									<input class="" type="text" id="city" name="city" size="20">
									<!-- class="btn001"> --><input id="search" type="submit" value="搜索"/>
								<!-- <a id="search" href="#">搜索</a> -->
							</form>
						</div>
					</div>
				</div>
				<!-- 新增内容 -->
				<%if (admin){ %>
				<div class="add">
					<table>
						<tr>
						<td class="btn001"><a id="add" href="#">新增景点</a></td>
						</tr>
					</table>
				</div>
				<%} %>
				<!-- 搜索结果 -->
				<div class="list">
					<div>
						<table class="list" style="border: 1px solid #a8aeb2;">
								<thead>
								<tr>
									<td>景点ID</td>
									<td>景点名称</td>
									<td>所在城市</td>
									<td>是否收费（元）</td>
									<td>景点详情</td>
								</tr>
								</thead>
								<tbody>
								<c:forEach var="bean" items="${list }" >
									<c:forEach var="ret" items="${bean[0] }"></c:forEach>
									<%-- <%i = i+1; %> --%>
									<tr>
										<td>${bean.id }</td>
										<td>${bean.name }</td>
										<td>${bean.city }</td>
										<td>${bean.consumption }</td>
										<td class="btn001"><a id="${bean.id }" href="detailSS?mainId=${bean.id }">详情</a></td>
									</tr>
								</c:forEach>
								</tbody>
						</table>
					</div>
					<% 
							int cPage = 1;
							int tPage = 1;
							int lPage = 1;
							int nPage = 1;
						if (request.getAttribute("currentPage") != null || request.getAttribute("totalPage")!= null){
							cPage = (Integer)request.getAttribute("currentPage"); 
							tPage = (Integer)request.getAttribute("totalPage");
							lPage = cPage == 1? 1:cPage-1;
							nPage = cPage == tPage? tPage:cPage+1;
						} else {
							response.sendRedirect("list");
						}
						String pam = "";
						
						
						if (request.getAttribute("sName")!= null || request.getAttribute("city")!= null){
							if (request.getAttribute("sName") != null){
								pam = "&name="+ (String)request.getAttribute("sName");
							} else {
								pam = "&name=";
							}
							
							if (request.getAttribute("city") != null){
								pam = pam + "&city=" + (String)request.getAttribute("city");
							} else {
								pam = pam + "&city=";
							}
						}
					%>
					<div class="nav">
						<ul style="margin-left: 500px;">
							<li id="first" style="display: inline;float: left;"><a href="/TMS/list?page=1<%=pam %>">首页</a>&nbsp;&nbsp;</li>
							<li id="before" style="display: inline;float: left;"><a href="/TMS/list?page=<%=lPage %><%=pam %>">上一页</a>&nbsp;</li>
							<li id="before" style="display: inline;float: left;"><span><%=cPage %> / <%=tPage %></span>&nbsp;</li>
							<li id="next" style="display: inline;float: left;"><a href="/TMS/list?page=<%=nPage %><%=pam %>">下一页</a>&nbsp;&nbsp;</li>
							<li id="last" style="display: inline;float: left;"><a href="/TMS/list?page=<%=tPage %><%=pam %>">末页</a>&nbsp;&nbsp;</li>
						</ul>
						<br><a></a>
						</div>
						
					</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	window.onload = function(){
		<%
			if (request.getAttribute("currentPage")!= null){
		%>
		windows.location.href="/TMS/list?page=1";
		<%}%>
		<%
		if (request.getAttribute("refresh") != null && request.getAttribute("refresh").equals("YES")){
		%>
		/* 以表单的submit方式提交跳转到本页面，会自动刷新本页面 */
		parent.location.href="index.jsp";
		<%}%>
	}
$(function(){
	$("#add").click(function(){
		window.location.href="add.jsp";
	})
})

</script>
</html>