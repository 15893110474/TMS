package com.xxu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxu.entity.Comment;
import com.xxu.entity.Persons;
import com.xxu.entity.ScenicSpot;
import com.xxu.services.CommentService;
import com.xxu.services.HotelService;
import com.xxu.services.PersonsService;
import com.xxu.services.RestaurantService;
import com.xxu.services.ScenicSpotService;
import com.xxu.services.impl.CommentServiceImpl;
import com.xxu.services.impl.HotelServiceImpl;
import com.xxu.services.impl.PersonsServiceImpl;
import com.xxu.services.impl.RestaurantServiceImpl;
import com.xxu.services.impl.ScenicSpotServiceImpl;

/**加载个人中心的数据
 * Servlet implementation class PersonCenterServlet
 */
@WebServlet("/PersonCenterServlet")
public class PersonCenterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PersonsService ps = new PersonsServiceImpl();
    private ScenicSpotService ss = new ScenicSpotServiceImpl();
    private RestaurantService rs = new RestaurantServiceImpl();
    private HotelService hs = new HotelServiceImpl();
    private CommentService cs = new CommentServiceImpl();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonCenterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
		int pid = -1;
		for (Cookie cookie : cookies) {
			if ("pid".equals(cookie.getName())) {
				pid = Integer.parseInt(cookie.getValue());
			}
		}
		if (pid != -1) {//登陆状态 
			Persons person = ps.findPersonById(pid);
			List<Comment> list = cs.selectByUser(pid);
			List<ScenicSpot> list2 = ss.findScenicSpotByPid(pid);
			request.setAttribute("person", person);
			request.setAttribute("clist", list);
			request.setAttribute("slist", list2);
			
		}
		
		request.getRequestDispatcher("/pCenter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
