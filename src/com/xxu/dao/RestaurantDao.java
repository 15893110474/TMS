package com.xxu.dao;

import java.util.List;

import com.xxu.entity.Restaurant;

public interface RestaurantDao {

	// 获取所有的饭店信息
	public List<Restaurant> findAll();
	
	// 添加饭店信息
	public void add(Restaurant res);
	
	// 根据id查询饭店信息
	public Restaurant findById(Integer id);
	
	// 更新饭店信息
	public void update(Restaurant res);
	
	// 根据id删除饭店信息
	public void deleteById(Integer id);
	
	public List<Restaurant> findBySid(Integer id);
	// 根据名字查询
	public Restaurant findByName(String name);
	
	// 获取表中数据总条数
	public int count();
	
	// 分页查询
	public List<Restaurant> findByIndexAndSize(int index, int size);

}
