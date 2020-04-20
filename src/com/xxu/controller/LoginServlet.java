package com.xxu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxu.entity.Persons;
import com.xxu.services.PersonsService;
import com.xxu.services.impl.PersonsServiceImpl;

/**登录功能的实现
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonsService ps = new PersonsServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Persons p = ps.login(username, password);
		if (p == null) {
			request.setAttribute("msg", "账号或密码错误，请重新登录");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		String res = p.getUsername();
		Integer admin = p.getAdmin();
		/*if (username == null || password == null || username.equals("") || password.equals("")) {
			res = "用户名或密码不能为空";
			request.setAttribute("info", res);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}*/
		if (res != null) {
			if(res.equals(username)) {
				if (admin == 1) {
					Cookie c = new Cookie("admin","YES");
					c.setMaxAge(1*60*60);
					response.addCookie(c);
				}
				Cookie c = new Cookie("username",username);
				String str = p.getId().toString();
				Cookie d = new Cookie("pid",str);
				d.setMaxAge(1*60*60);
				response.addCookie(d);
				//设置登录有效时间为1小时
				c.setMaxAge(1*60*60);
				response.addCookie(c);
				/*request.setAttribute("info", "登录成功");
				request.setAttribute("username", username);*/
				request.setAttribute("refresh", "YES");
				//request.getRequestDispatcher("/index.jsp").forward(request, response);
				response.sendRedirect("list");
				return;
			} else {
				request.setAttribute("info", res);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
