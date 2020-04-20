package com.xxu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxu.dao.CommentDao;
import com.xxu.dao.HotelDao;
import com.xxu.dao.RestaurantDao;
import com.xxu.dao.impl.CommentDaoImpl;
import com.xxu.dao.impl.HotelDaoImpl;
import com.xxu.dao.impl.RestaurantDaoImpl;
import com.xxu.entity.Comment;
import com.xxu.entity.Hotel;
import com.xxu.entity.Restaurant;
import com.xxu.entity.ScenicSpot;
import com.xxu.services.RestaurantService;
import com.xxu.services.ScenicSpotService;
import com.xxu.services.impl.ScenicSpotServiceImpl;

/**加载景区详情页的所有数据
 * Servlet implementation class DetailSSServlet
 */
@WebServlet("/DetailSSServlet")
public class DetailSSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScenicSpotService ss = new ScenicSpotServiceImpl();
    private RestaurantDao rd = new RestaurantDaoImpl(); 
    private HotelDao hd = new HotelDaoImpl();
    private CommentDao cd = new CommentDaoImpl();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public DetailSSServlet() {
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
		if (mainId != null && !mainId.equals("")) {
			int id = Integer.parseInt(mainId);
			ScenicSpot scenicSpot = ss.findScenicSpotById(id);
			List<Restaurant> list = rd.findBySid(id);
			List<Hotel> list2 = hd.findBySid(id);
			List<Comment> list3 = cd.findBySid(id);
			if (scenicSpot!=null && list!=null && list2!=null) {
				request.setAttribute("ss", scenicSpot);
				request.setAttribute("rl", list);//饭馆
				request.setAttribute("hl", list2);//宾馆
				request.setAttribute("cl", list3);//评论
				request.setAttribute("sid", mainId);//SID
				request.getRequestDispatcher("/detail.jsp").forward(request, response);
				return;
			}
		} else {
			request.setAttribute("msg", "系统错误，请返回重试！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
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
