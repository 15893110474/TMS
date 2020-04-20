package com.xxu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xxu.dao.RestaurantDao;
import com.xxu.entity.Restaurant;
import com.xxu.utils.JdbcUtils;

public class RestaurantDaoImpl implements RestaurantDao {

	@Override
	public List<Restaurant> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from restaurant";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<Restaurant> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Restaurant.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void add(Restaurant res) {
		// TODO Auto-generated method stub
		String sql = "insert into restaurant(sid,name,introduce,consumption,address,imgUrl) values(?,?,?,?,?,?)";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Object[] params = new Object[] {
				res.getSId(),
				res.getName(),
				res.getIntroduce(),
				res.getConsumption(),
				res.getAddress(),
				res.getImgUrl()				
		}; 
		
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Restaurant findById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from restaurant where id = ?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Restaurant res = null;
		try {
			res = qr.query(sql, new BeanHandler<>(Restaurant.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public void update(Restaurant res) {
		// TODO Auto-generated method stub
		String sql = "update restaurant set sid=?,name=?,introduce=?,consumption=?,address=?,imgUrl=? where id=?";
		Object[] params = new Object[]{
			res.getSId(),
			res.getName(),
			res.getIntroduce(),
			res.getConsumption(),
			res.getAddress(),
			res.getImgUrl(),
			res.getId()
		};
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
	String sql = "delect * from restaurant where id = ?";
	QueryRunner qr = JdbcUtils.getQueryRunner();
	
	try {
		qr.update(sql, id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Override
	public Restaurant findByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from restaurant where name = ?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Restaurant res = null;
		try {
			res = qr.query(sql, new BeanHandler<>(Restaurant.class),name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return res;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from restaurant";
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
	public List<Restaurant> findByIndexAndSize(int index, int size) {
		// TODO Auto-generated method stub
		String sql = "selsect * from restaurant limit ?,?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<Restaurant> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Restaurant.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Restaurant> findBySid(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from restaurant where sid=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<Restaurant> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Restaurant.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
