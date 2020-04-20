package com.xxu.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxu.entity.Comment;
import com.xxu.services.CommentService;
import com.xxu.services.impl.CommentServiceImpl;

/**提交评论功能
 * Servlet implementation class ForumServlet
 */
@WebServlet("/ForumServlet")
public class ForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CommentService cs = new CommentServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String forum = request.getParameter("forum");
		String sid = request.getParameter("sid");
		String pid = request.getParameter("pid");
		Comment c = new Comment();
		c.setContent(forum);
		c.setReleaseTime(new Date());
		c.setPId(Integer.parseInt(pid));
		c.setSd(Integer.parseInt(sid));
		cs.addComment(c);
		request.getRequestDispatcher("/detailSS?mainId="+sid).forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
