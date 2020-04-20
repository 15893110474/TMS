package com.xxu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xxu.dao.ScenicSpotDao;
import com.xxu.entity.ScenicSpot;
import com.xxu.utils.JdbcUtils;

public class ScenicSpotImpl implements ScenicSpotDao {

	@Override
	public List<ScenicSpot> findAll() {
		// TODO Auto-generated method stub
		
		String sql = "select * from scenicspot";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<ScenicSpot> list = new ArrayList<ScenicSpot>();
		try {
			list = qr.query(sql, new BeanListHandler<>(ScenicSpot.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;		
	}

	@Override
	public void add(ScenicSpot sces) {
		// TODO Auto-generated method stub
		String sql = "insert into scenicspot(name,city,address,characteristic,imgUrl,introduce,imgUrl2,consumption) values(?,?,?,?,?,?,?,?)";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Object[] params = new Object[]{
				sces.getName(), 
				sces.getCity(), 
				sces.getAddress(),
				sces.getCharacteristic(),
				sces.getImgUrl(),
				sces.getIntroduce(),
				sces.getImgUrl2(),
				sces.getConsumption(),
				/*sces.getpId(),?*/
		};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 抛出异常
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public ScenicSpot findById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from scenicspot where id=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		ScenicSpot sces = null;
		try {
			sces = qr.query(sql, new BeanHandler<>(ScenicSpot.class), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sces;
	}

	@Override
	public void update(ScenicSpot sces) {
		// TODO Auto-generated method stub
		String sql = "update scenicspot set name=?,city=?,address=?,characteristic=?,imgUrl=?,introduce=?,imgUrl2=?,consumption=? where id=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Object[] params = new Object[]{
				sces.getName(), 
				sces.getCity(), 
				sces.getAddress(),
				sces.getCharacteristic(),
				sces.getImgUrl(),
				sces.getIntroduce(),
				sces.getImgUrl2(),
				sces.getConsumption(),
				sces.getId()
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
		String sql = "delete from scenicspot where id=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public ScenicSpot findByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from scenicspot where name=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		ScenicSpot sces = null;
		try {
			sces = qr.query(sql, new BeanHandler<>(ScenicSpot.class), name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new RuntimeException(e.getMessage());
		}
		
		return sces;	
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from scenicspot";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		int count = 0;
		try {
			// 默认返回第一行第一列的数据
			Long query = qr.query(sql, new ScalarHandler<Long>());
			// 将long转为整型
			count = query.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int count(String name , String city) {
		String n = "";
		String c = "";
		if (name!=null && !name.equals("")) {
			n = "%"+name+"%";
		}
		if (city != null && !city.equals("")) {
			c = "%"+city+"%";
		}		
		String sql = "select count(*) from scenicspot where name like ? or city like ?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		int count = 0;
		try {
			// 默认返回第一行第一列的数据
			Long query = qr.query(sql, new ScalarHandler<Long>(),n,c);
			// 将long转为整型
			count = query.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;		
	}
	@Override
	public List<ScenicSpot> findByIndexAndSize(int index, int size) {
		// TODO Auto-generated method stub
		String sql = "select * from scenicspot limit ?,?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<ScenicSpot> list = new ArrayList<ScenicSpot>();
		try {
			list = qr.query(sql, new BeanListHandler<>(ScenicSpot.class), index, size);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return list;
	}

	@Override
	public List<ScenicSpot> findLikeByNameAndCity(String name, String city , int index , int size) {
		// TODO Auto-generated method stub
		
		String n = "";
		String c = "";
		if (name!=null && !name.equals("")) {
			n = "%"+name+"%";
		}
		if (city != null && !city.equals("")) {
			c = "%"+city+"%";
		}
		String sql = "select * from scenicspot where name like ? or city like ? LIMIT ?,?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<ScenicSpot> list = new ArrayList<ScenicSpot>();
		try {
			list = qr.query(sql, new BeanListHandler<>(ScenicSpot.class),n,c,index,size);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		return list;
	}
	
	@Override
	public List<ScenicSpot> findByPid(Integer pid){
		String sql = "select * from scenicspot where pid = ?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<ScenicSpot> list = new ArrayList<ScenicSpot>();
		try {
			list = qr.query(sql, new BeanListHandler<>(ScenicSpot.class),pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
