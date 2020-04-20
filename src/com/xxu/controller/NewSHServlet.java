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
import com.xxu.entity.ScenicSpot;
import com.xxu.services.HotelService;
import com.xxu.services.impl.HotelServiceImpl;

/**添加新的宾馆
 * Servlet implementation class NewSHServlet
 */
@WebServlet("/NewSHServlet")
public class NewSHServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HotelService hs = new HotelServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewSHServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClassLoader cl = NewSSServlet.class.getClassLoader();
		InputStream is = cl.getResourceAsStream("com/xxu/path.properties");
		Properties pro = new Properties();
		pro.load(is);
		String path = pro.getProperty("imgPath");
		System.out.println(path);
		int i = 1;
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
		ScenicSpot scenicSpot = new ScenicSpot();
		Hotel hotel = new Hotel();
		while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            if (!item.isFormField()) {
                String fileName = item.getName();
                fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                hotel.setImgUrl(fileName);
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
                	hotel.setName(value);
                }
                if(fieldName.equals("address")) {
                	hotel.setAddress(value);
                }
                if(fieldName.equals("introduce")) {
                	hotel.setIntroduce(value);
                }
                if(fieldName.equals("type")) {
                	hotel.setType(value);
                }
                if(fieldName.equals("price")) {
                	hotel.setPrice(Integer.parseInt(value));
                }
                if (fieldName.equals("SId")) {
                	hotel.setSId(Integer.parseInt(value));
                }
            }
		}

		String ret = hs.addHotel(hotel);
		if (ret.equals("添加成功")) {
			request.setAttribute("msg", "宾馆添加成功！！！");
			request.getRequestDispatcher("success.jsp?sid="+hotel.getSId()).forward(request, response);
			return;
		} else {
			request.setAttribute("msg", ret);
			request.getRequestDispatcher("addHotel.jsp").forward(request, response);
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
