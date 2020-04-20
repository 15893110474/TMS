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

import com.xxu.entity.ScenicSpot;
import com.xxu.services.ScenicSpotService;
import com.xxu.services.impl.ScenicSpotServiceImpl;

/**添加新的景区
 * Servlet implementation class NewSSServlet
 */
@WebServlet("/NewSSServlet")
public class NewSSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ScenicSpotService  ss = new ScenicSpotServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewSSServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClassLoader cl = NewSSServlet.class.getClassLoader();
		//获取配置的本地路径
		InputStream is = cl.getResourceAsStream("com/xxu/path.properties");
		Properties pro = new Properties();
		pro.load(is);
		//获取本地路径
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
		while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            if (!item.isFormField()) {
                String fileName = item.getName();
                fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                if (i == 1) {
                	//设置图片1名
                	scenicSpot.setImgUrl(fileName);
                	i++;
                } else {
                	//设置图片2名
                	scenicSpot.setImgUrl2(fileName);
                }
                
                //设置文件保存位置（上面的本地目录）
                String serverPath = path;//request.getRealPath("/img");
                File file = new File(serverPath, fileName);
                try {
                    //保存文件
                	item.write(file);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
            	String fieldName = item.getFieldName();
                String value = item.getString("UTF-8");
                if(fieldName.equals("name")) {
                	scenicSpot.setName(value);
                }
                if(fieldName.equals("city")) {
                	scenicSpot.setCity(value);
                }
                if(fieldName.equals("address")) {
                	scenicSpot.setAddress(value);
                }
                if(fieldName.equals("introduce")) {
                	scenicSpot.setIntroduce(value);
                }
                if(fieldName.equals("characteristic")) {
                	scenicSpot.setCharacteristic(value);
                }
                if(fieldName.equals("consumption")) {
                	scenicSpot.setConsumption(Integer.parseInt(value));
                }
            }
		}
		//保存到数据库
		String ret = ss.addScenicSpot(scenicSpot);
		//查找刚才保存的内容
		ScenicSpot spot = ss.findScenicSpotByName(scenicSpot.getName());
		if (ret.equals("添加成功")) {
			request.setAttribute("msg", "景区添加成功！！！");
			request.setAttribute("sid", spot.getId());
			request.getRequestDispatcher("success.jsp?sid="+spot.getId()).forward(request, response);
			return;
		} else {
			request.setAttribute("msg", ret);
			request.getRequestDispatcher("add.jsp").forward(request, response);
			return;
		}
        //response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
			

		}

}
