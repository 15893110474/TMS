package com.xxu.services;

import java.util.List;

import com.xxu.entity.Comment;

public interface CommentService {
	//添加新的评论
	public void addComment(Comment c);
	//查找全部评论
	public List<Comment> selectAll();
	//根据人员查找评论
	public List<Comment> selectByUser(Integer id);
	//根据景区查找评论
	public List<Comment> selectBySS(Integer id);
}
