package com.xxu.dao;

import java.util.List;

import com.xxu.entity.Comment;

public interface CommentDao {

	// 获取所有的评论信息
	public List<Comment> findAll();
	
	// 添加评论信息
	public void add(Comment com);
	
	// 根据id查询评论信息
	public Comment findById(Integer id);
	
	// 根据添加人员id查询评论信息
	public List<Comment> findByPid(Integer id);	
	// 更新评论信息
	public void update(Comment com);
	
	// 根据id删除评论信息
	public void deleteById(Integer id);
	
	// 获取表中数据总条数
	public int count();
	
	// 分页查询
	public List<Comment> findByIndexAndSize(int index, int size);

	public List<Comment> findBySid(Integer id);
}
