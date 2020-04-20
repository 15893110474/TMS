package com.xxu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xxu.dao.HotelDao;
import com.xxu.entity.Hotel;
import com.xxu.utils.JdbcUtils;

public class HotelDaoImpl implements HotelDao {

	@Override
	public List<Hotel> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from hotel";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<Hotel> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Hotel.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void add(Hotel hotel) {
		// TODO Auto-generated method stub
		String sql = "insert into hotel(sid,name,introduce,type,price,address,imgUrl) values(?,?,?,?,?,?,?)";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Object[] params = new Object[] {
				hotel.getSId(),
				hotel.getName(),
				hotel.getIntroduce(),
				hotel.getType(),
				hotel.getPrice(),
				hotel.getAddress(),
				hotel.getImgUrl()				
		};
		
		try {
			qr.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Hotel findById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from hotel where id=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Hotel hotel = null;
		try {
			hotel = qr.query(sql, new BeanHandler<>(Hotel.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotel;
	}

	@Override
	public void update(Hotel hotel) {
		// TODO Auto-generated method stub
		String sql = "update hotel set sid=?,name=?,introduce=?,type=?,price=?,address=?,imgUrl=? where id=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Object[] params = new Object[] {
				hotel.getSId(),
				hotel.getName(),
				hotel.getIntroduce(),
				hotel.getType(),
				hotel.getPrice(),
				hotel.getAddress(),
				hotel.getImgUrl(),
				hotel.getId()
		};
		
		try {
			qr.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from hotel where id=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		try {
			qr.update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Hotel findByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from hotel where name=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Hotel hotel = null;
		try {
			hotel = qr.query(sql, new BeanHandler<>(Hotel.class),name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return hotel;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from hotel";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		int count = 0;
		try {
			Long query = qr.query(sql,new ScalarHandler<Long>());
			count = query.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Hotel> findByIndexAndSize(int index, int size) {
		// TODO Auto-generated method stub
		String sql = "select * from hotel limit ?,?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<Hotel> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Hotel.class),index,size);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return list;
	}

	@Override
	public List<Hotel> findBySid(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from hotel where sid=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<Hotel> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Hotel.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
