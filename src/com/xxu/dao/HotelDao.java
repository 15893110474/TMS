package com.xxu.dao;

import java.util.List;

import com.xxu.entity.Hotel;

public interface HotelDao {

	// 获取所有的旅馆信息
	public List<Hotel> findAll();
	
	// 添加旅馆信息
	public void add(Hotel hotel);
	
	// 根据id查询旅馆信息
	public Hotel findById(Integer id);

	public List<Hotel> findBySid(Integer id);
	// 更新旅馆信息
	public void update(Hotel hotel);
	
	// 根据id删除旅馆信息
	public void deleteById(Integer id);
	
	// 根据名字查询
	public Hotel findByName(String name);
	
	// 获取表中数据总条数
	public int count();
	
	// 分页查询
	public List<Hotel> findByIndexAndSize(int index, int size);

}
