package com.xxu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxu.dao.PersonsDao;
import com.xxu.dao.impl.PersonsDaoImpl;
import com.xxu.entity.Persons;
import com.xxu.services.PersonsService;
import com.xxu.services.impl.PersonsServiceImpl;

/**注册功能的实现 
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonsService personService = new PersonsServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		String password2 = request.getParameter("password2");
		String msg = "";
		if (name == null || name.equals("")) {
			msg="请输入完整的注册信息";
		}
		if (age == null || age.equals("")) {
			msg="请输入完整的注册信息";
		}
		if (sex == null || sex.equals("")) {
			msg="请输入完整的注册信息";
		}
		if (phone == null || phone.equals("")) {
			msg="请输入完整的注册信息";
		}
		if (username == null || username.equals("")) {
			msg="请输入完整的注册信息";
		}
		if (password == null || password.equals("")) {
			msg="请输入完整的注册信息";
		}
		if (password2 == null || password2.equals("")) {
			msg="请输入完整的注册信息";
		}
		if (!msg.equals("")) {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		} else {
			if (!password.equals(password2)) {
				request.setAttribute("msg", "两次输入密码不一致");
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;	
			}
		}
		Persons emp = new Persons(null, name, sex, Integer.parseInt(age), phone, username, password);
		// 添加操作
		
		try {
			personService.addPerson(emp);
			
			// 重定向
			//response.sendRedirect(request.getContextPath() + "/list");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;				
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
