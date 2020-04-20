<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>旅游管理系统-景区详情</title>
	<script src="js/jquery.js"></script>
	<link type="text/css" rel="styleSheet"  href="css/subject.css" />
	<link type="text/css" rel="styleSheet"  href="css/list.css" />
	<script type="text/javascript">
		function pleaseLogin(){
			if (confirm("只有会员可以访问，请登录？")){
				window.location.href="/TMS/login.jsp";
			} else {
				return;
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
			//Boolean ret = false;
			String uname = null;
			String pid ="";
			if (cookie != null){
			for(int i=0;i<cookie.length;i++){
				if ("pid".equals(cookie[i].getName())){
					pid = cookie[i].getValue();
				}
			    if("username".equals(cookie[i].getName())){
			    	//ret = true;
			    	uname = cookie[i].getValue();
			        //System.out.println(cookie[i].getValue() + "666");//得到peter
			        //break;
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
		<div class="left" style="background-color: #000000;border:2px solid;border-color:#89C8F5">
			<div class="title">
				景区详情
			</div>
		<div class="article-content" style="color: #fff;">
			<p><span class="bjh-p">${ss.name }</span></p>
			<div class="img-container">
				<img class="large" src="./img/${ss.imgUrl }">
			</div>
			<p><span class="bjh-p">${ss.introduce }</span></p>
			<div class="img-container">
				<img class="large" src="./img/${ss.imgUrl2 }">
			</div>
			<p><span class="bjh-p">${ss.characteristic }</span></p>
		</div>
		<!-- 评论区 -->
		<div class="forum" style="background-color: #fff;">
			<div class="title" style="text-align: left;">
				<span style="margin-left: 20px">游客评论：</span>
			</div>
			<%if (uname == null){ %>
			<div style="display:none;">
			<%} else { %>
			<div>
			<%} %>
			<form action="forum" method="post">
				<input type="hidden" name="pid" value="<%=pid %>" />
				<input type="hidden" name="sid" value="${sid }"  />
				<textarea rows="5" cols="47" name="forum"></textarea>
				<input type="submit" value="提交">
			</form></div>
			<div class="forum_list">
                <ul  class="my_fav_list">
					<c:forEach var="bean" items="${cl }">
                    <li class="my_fav_list_li" id="">
                        <span  class="my_fav_list_a" href="" target="_blank">
                            	${bean.content }
                        </span>
                        <br>
                        <label class="my_fav_list_label" style="float: right;margin-bottom: 5px">
                            <span >${bean.dateStr }</span>
                            <br>
                            <!-- <a  class="cancel_fav"><em>取消</em></a> -->
                        </label>
                    </li>
					</c:forEach>	
                </ul>
            </div>
		</div>
		</div>
		<div class="right" style="border:2px solid;border-color:#89C8F5 ">
			<div class="restaurant">
				<div class="title">
					周边饭店
				</div>
				<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<div class="info">
					<ul class="array">
						<c:forEach var="bean" items="${rl }">
							<%-- <c:forEach var="ret" items="${rl[0] }"></c:forEach> --%>
							<%if (uname!=null && !uname.equals("")){ %>
							<li><span class="list">${bean.id }</span>&nbsp;&nbsp;<a class="ltitle" href="detailSR?mainId=${bean.id }">${bean.name }</a></li>
							<%}else{ %>
							<li><span class="list">${bean.id }</span>&nbsp;&nbsp;<a class="ltitle" href="javascript:pleaseLogin();">${bean.name }</a></li>
							<%}%>
						</c:forEach>						
						<li><span class="list">1</span>&nbsp;&nbsp;<a class="ltitle" href="rDetail.jsp">7天度假酒店</a></li>
						<li><span class="list">2</span>&nbsp;&nbsp;<a class="ltitle" href="rDetail.jsp">明日宾馆</a></li>
						<li><span class="list">3</span>&nbsp;&nbsp;<a class="ltitle" href="rDetail.jsp">万豪网络宾馆</a></li>
						<li><span class="list">4</span>&nbsp;&nbsp;<a class="ltitle" href="rDetail.jsp">帝豪大酒店</a></li>
						<li><span class="list">5</span>&nbsp;&nbsp;<a class="ltitle" href="rDetail.jsp">拉蒂兹旅社</a></li>
						<li><span class="list">6</span>&nbsp;&nbsp;<a class="ltitle" href="rDetail.jsp">还有谁住宿</a></li>
						<li><span class="list">7</span>&nbsp;&nbsp;<a class="ltitle" href="rDetail.jsp">你我他旅游酒店</a></li>
						<li><span class="list">8</span>&nbsp;&nbsp;<a class="ltitle" href="rDetail.jsp">还有啥呢</a></li>
						<li><span class="list">9</span>&nbsp;&nbsp;<a class="ltitle" href="rDetail.jsp">最后一个了</a></li>
					</ul>
				</div>
			</div>
			<div class="hotel">
				<div class="title">
					周边宾馆
				</div>
				<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<div class="info">
					<ul class="array">
						<c:forEach var="bean" items="${hl }">
							<%-- <c:forEach var="ret" items="${rl[0] }"></c:forEach> --%>
							<%if (uname!=null && !uname.equals("")){ %>
							<li><span class="list">${bean.id }</span>&nbsp;&nbsp;<a class="ltitle" href="detailSH?mainId=${bean.id }">${bean.name }</a></li>
							<%}else{ %>
							<li><span class="list">${bean.id }</span>&nbsp;&nbsp;<a class="ltitle" href="javascript:pleaseLogin();">${bean.name }</a></li>
							<%} %>
						</c:forEach>							
						<li><span class="list">1</span>&nbsp;&nbsp;<a class="ltitle" href="hDetail.jsp">7天度假酒店</a></li>
						<li><span class="list">2</span>&nbsp;&nbsp;<a class="ltitle" href="hDetail.jsp">明日宾馆</a></li>
						<li><span class="list">3</span>&nbsp;&nbsp;<a class="ltitle" href="hDetail.jsp">万豪网络宾馆</a></li>
						<li><span class="list">4</span>&nbsp;&nbsp;<a class="ltitle" href="hDetail.jsp">帝豪大酒店</a></li>
						<li><span class="list">5</span>&nbsp;&nbsp;<a class="ltitle" href="hDetail.jsp">拉蒂兹旅社</a></li>
						<li><span class="list">6</span>&nbsp;&nbsp;<a class="ltitle" href="hDetail.jsp">还有谁住宿</a></li>
						<li><span class="list">7</span>&nbsp;&nbsp;<a class="ltitle" href="hDetail.jsp">你我他旅游酒店</a></li>
						<li><span class="list">8</span>&nbsp;&nbsp;<a class="ltitle" href="hDetail.jsp">还有啥呢</a></li>
						<li><span class="list">9</span>&nbsp;&nbsp;<a class="ltitle" href="hDetail.jsp">最后一个了</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
			<a href="#" style="width:50px;height:50px;background-color: #CCC;color:#000000">
				<span>回到</span><br><span>顶部</span>
			</a>
</body>
</html>