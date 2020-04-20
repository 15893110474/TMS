package com.xxu.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.xxu.entity.Hotel;
import com.xxu.entity.Restaurant;
import com.xxu.services.RestaurantService;
import com.xxu.services.impl.RestaurantServiceImpl;

/**添加新的饭馆
 * Servlet implementation class NewSRServlet
 */
@WebServlet("/NewSRServlet")
public class NewSRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantService rs = new RestaurantServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewSRServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ClassLoader cl = NewSSServlet.class.getClassLoader();
		InputStream is = cl.getResourceAsStream("com/xxu/path.properties");
		Properties pro = new Properties();
		pro.load(is);
		String path = pro.getProperty("imgPath");
		System.out.println(path);
		FileItemFactory factory = new DiskFileItemFactory();
         // 创建文件上传处理器
		ServletFileUpload upload = new ServletFileUpload(factory);
         // 开始解析请求信息
		List items = null;
		try {
			items = upload.parseRequest(request);
		}
		catch (FileUploadException e) {
             e.printStackTrace();
		}
         // 对所有请求信息进行判断
		Iterator iter = items.iterator();
		Restaurant restaurant = new Restaurant();
		while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            if (!item.isFormField()) {
                String fileName = item.getName();
                fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                restaurant.setImgUrl(fileName);
                String serverPath = path;//request.getRealPath("/img");
                File file = new File(serverPath, fileName);
                try {
                    item.write(file);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
            	String fieldName = item.getFieldName();
                String value = item.getString("UTF-8");
                if(fieldName.equals("name")) {
                	restaurant.setName(value);
                }
                if(fieldName.equals("address")) {
                	restaurant.setAddress(value);
                }
                if(fieldName.equals("introduce")) {
                	restaurant.setIntroduce(value);
                }
                if(fieldName.equals("consumption")) {
                	restaurant.setConsumption(Integer.parseInt(value));
                }
                if(fieldName.equals("SId")) {
                	restaurant.setSId(Integer.parseInt(value));
                }
            }
		}
		String ret = rs.addRestaurant(restaurant);
		if (ret.equals("添加成功")) {
			request.setAttribute("msg", "饭馆添加成功！！！");
			request.getRequestDispatcher("success.jsp?sid="+restaurant.getSId()).forward(request, response);
			return;
		} else {
			request.setAttribute("msg", ret);
			request.getRequestDispatcher("addRestaurant.jsp").forward(request, response);
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
