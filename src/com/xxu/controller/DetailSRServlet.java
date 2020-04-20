package com.xxu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxu.entity.Restaurant;
import com.xxu.services.RestaurantService;
import com.xxu.services.impl.RestaurantServiceImpl;

/**加载饭馆详情页数据
 * Servlet implementation class DetailSRServlet
 */
@WebServlet("/DetailSRServlet")
public class DetailSRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantService rs = new RestaurantServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailSRServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String mainId = request.getParameter("mainId");
		String sid = request.getParameter("sid");
		if (mainId != null && !mainId.equals("")) {
			Restaurant restaurant = rs.findById(Integer.parseInt(mainId));
			request.setAttribute("restaurant", restaurant);
			request.getRequestDispatcher("/rDetail.jsp").forward(request, response);
			return;
		} else {
			request.setAttribute("msg", "系统错误，请重试");
			request.getRequestDispatcher("/detailSS?mainId="+sid).forward(request, response);
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
