package com.xxu.dao.impl;

import java.sql.SQLException;
import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xxu.dao.CommentDao;
import com.xxu.entity.Comment;
import com.xxu.utils.JdbcUtils;

public class CommentDaoImpl implements CommentDao {

	@Override
	public List<Comment> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from comment";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<Comment> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Comment.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void add(Comment com) {
		// TODO Auto-generated method stub
		String sql = "insert into comment (sid,pid,content,releaseTime) value(?,?,?,?)";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Object[] params = new Object[] {
				com.getSd(),
				com.getPId(),
				com.getContent(),
				com.getReleaseTime()
		};
		
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Comment findById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from comment where id=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Comment com = null;
		try {
			com = qr.query(sql, new BeanHandler<>(Comment.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return com;
	}

	@Override
	public void update(Comment com) {
		// TODO Auto-generated method stub
		String sql = "update comment set sid=?,pid=?,content=?,releaseTime=? where id=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Object[] params = new Object[] {
				com.getSd(),
				com.getPId(),
				com.getContent(),
				com.getReleaseTime(),
				com.getId()
		};
		
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delect from comment where id=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		
		try {
			qr.update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/*	@Override
	public Comment findByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from comment where name "
		return null;
	}*/

	@Override
	public int count() {
		// TODO Auto-generated method stub
		String sql = "selcet count(*) from comment";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		int count = 0;
		try {
			Long query = qr.query(sql, new ScalarHandler<Long>());
			count = query.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Comment> findByIndexAndSize(int index, int size) {
		// TODO Auto-generated method stub
		String sql = "select * from comment limit ?,?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<Comment> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Comment.class),index,size);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return list;
	}

	@Override
	public List<Comment> findByPid(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from comment where pid=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<Comment> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Comment.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Comment> findBySid(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from comment c where sid=? order by c.id desc";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<Comment> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Comment.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
