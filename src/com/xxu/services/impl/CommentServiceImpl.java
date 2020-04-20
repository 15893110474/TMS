package com.xxu.services.impl;

import java.util.List;

import com.xxu.dao.CommentDao;
import com.xxu.dao.impl.CommentDaoImpl;
import com.xxu.entity.Comment;
import com.xxu.services.CommentService;

public class CommentServiceImpl implements CommentService {

	private CommentDao cd = new CommentDaoImpl();
	@Override
	public void addComment(Comment c) {
		// TODO Auto-generated method stub
		if (c != null) {
			if (c.getContent()!=null && !c.getContent().equals("")) {
				cd.add(c);
			}else {
				System.out.println("内容为空不能添加");
			}
		}else {
			System.out.println("对象为空不能添加");
		}
		
	}

	@Override
	public List<Comment> selectAll() {
		// TODO Auto-generated method stub
		List<Comment> list = cd.findAll();
		return list;
	}

	@Override
	public List<Comment> selectByUser(Integer id) {
		// TODO Auto-generated method stub
		List<Comment> list = null;
		if (id != null && id >= 0) {
			list = cd.findByPid(id);
		}
		return list;
	}

	@Override
	public List<Comment> selectBySS(Integer id) {
		// TODO Auto-generated method stub
		List<Comment> list = null;
		if (id != null && id >= 0) {
			list = cd.findBySid(id);
		}
		return list;
	}

}
