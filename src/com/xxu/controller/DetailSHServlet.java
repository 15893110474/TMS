package com.xxu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxu.entity.Hotel;
import com.xxu.services.HotelService;
import com.xxu.services.impl.HotelServiceImpl;

/**加载宾馆详情页数据
 * Servlet implementation class DetailSHServlet
 */
@WebServlet("/DetailSHServlet")
public class DetailSHServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HotelService hs = new HotelServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailSHServlet() {
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
			Hotel hotel = hs.findById(Integer.parseInt(mainId));
			request.setAttribute("hotel", hotel);
			request.getRequestDispatcher("/hDetail.jsp").forward(request, response);
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
