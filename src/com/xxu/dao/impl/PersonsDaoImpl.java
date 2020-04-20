package com.xxu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xxu.dao.PersonsDao;
import com.xxu.entity.Persons;
import com.xxu.utils.JdbcUtils;

public class PersonsDaoImpl implements PersonsDao{

	@Override
	public List<Persons> findAll() {
		// TODO Auto-generated method stub
		
		String sql = "select * from persons";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<Persons> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Persons.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void add(Persons emp) {
		// TODO Auto-generated method stub
		String sql = "insert into persons(name,sex,age,phone,username,password) values(?,?,?,?,?,?)";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Object[] params = new Object[]{
				emp.getName(), 
				emp.getSex(), 
				emp.getAge(),
				emp.getPhone(),
				emp.getUsername(),
				emp.getPassword()
		};
		try {
			qr.update(sql, params );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 抛出异常
			throw new RuntimeException(e.getMessage());
		}
		
		
	}
	
	@Override
	public Persons findById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from persons where id=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Persons persons = null;
		try {
			persons = qr.query(sql, new BeanHandler<>(Persons.class), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return persons;
	}
	
	@Override
	public void update(Persons emp) {
		// TODO Auto-generated method stub
		String sql = "update persons set name=?,sex=?,age=?,phone=? where id=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Object[] params = new Object[]{
				emp.getName(),
				emp.getSex(),
				emp.getAge(),
				emp.getPhone(),
				emp.getId()
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
		String sql = "delete from persons where id=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Persons findByName(String name) {
		// TODO Auto-generated method stub
		
		String sql = "select * from persons where name=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Persons emp = null;
		try {
			emp = qr.query(sql, new BeanHandler<>(Persons.class), name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new RuntimeException(e.getMessage());
		}
		
		return emp;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from persons";
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

	@Override
	public List<Persons> findByIndexAndSize(int index, int size) {
		// TODO Auto-generated method stub
		String sql = "select * from persons limit ?,?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<Persons> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Persons.class), index, size);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return list;
	}

	@Override
	public Persons findByUserName(String userName) {
		// TODO Auto-generated method stub
		
		String sql = "select * from persons where username=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Persons emp = null;
		try {
			emp = qr.query(sql, new BeanHandler<>(Persons.class), userName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		return emp;		
	}
	
	
	

}
