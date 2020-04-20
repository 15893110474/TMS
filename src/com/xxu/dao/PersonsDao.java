package com.xxu.dao;

import java.util.List;

import com.xxu.entity.Persons;

public interface PersonsDao {

	// 获取所有的员工数据
	public List<Persons> findAll();
	
	// 添加员工数据
	public void add(Persons emp);
	
	// 根据id查询员工数据
	public Persons findById(Integer id);
	
	// 更新员工数据
	public void update(Persons emp);
	
	// 根据id删除员工数据
	public void deleteById(Integer id);
	
	// 根据名字查询
	public Persons findByName(String name);
	
	//根据用户名查找
	public Persons findByUserName(String userName);
	
	// 获取表中数据总条数
	public int count();
	
	// 分页查询
	public List<Persons> findByIndexAndSize(int index, int size);
	
}
