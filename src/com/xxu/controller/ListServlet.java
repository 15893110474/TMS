package com.xxu.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxu.entity.ScenicSpot;
import com.xxu.services.ScenicSpotService;
import com.xxu.services.impl.ScenicSpotServiceImpl;
import com.xxu.vo.PageBean;

import net.sf.json.JSONArray;

/**加载主页数据
 * Servlet implementation class ListServlet
 */
// 控制层调用业务层
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 创建业务层的对象
	private ScenicSpotService ss = new ScenicSpotServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int page = 0;
		request.setCharacterEncoding("UTF-8");
		// 获取提交的页码
		String pageStr = request.getParameter("page");
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		// 如果没有传页码，默认查询第一页
		if(pageStr == null){
			page = 1;
		}else{
			page = Integer.parseInt(pageStr);
			if(page <= 0){
				page = 1;
			}
		}
		//response.sendRedirect(request.getContextPath() + "/list");
		try {
			// 根据页码获取分页对象信息
			PageBean<ScenicSpot> pageBean = new PageBean<>();
			
			if ((name == null || name.equals("")) && (city == null || city.equals(""))){
				pageBean = ss.findScenicSpotByPage(page);
			} else {
				pageBean = ss.search(name, city, page);
				request.setAttribute("sName", name);
				request.setAttribute("city", city);
			}
			JSONArray json = JSONArray.fromObject(pageBean.getPageInfos());
			// 将数据放到请求对象中
			request.setAttribute("list", json);
			request.setAttribute("refresh", "YES");
			request.setAttribute("currentPage", pageBean.getCurrentPage());
			request.setAttribute("totalPage", pageBean.getTotalPage());
			// 转发到list.jsp
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			/*for (Object obj : pageBean.getPageInfos()) {
				ScenicSpot p = (ScenicSpot)obj;
				System.out.println(p.getName());
			}*/
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		}
		System.out.println("跳转过来了");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
