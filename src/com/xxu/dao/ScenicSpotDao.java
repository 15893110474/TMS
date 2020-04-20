package com.xxu.dao;

import java.util.List;

import com.xxu.entity.ScenicSpot;


public interface ScenicSpotDao {

	// 获取所有的员工数据
	public List<ScenicSpot> findAll();
	
	// 添加员工数据
	public void add(ScenicSpot sces);
	
	//public int getIdByName(String name);
	
	// 根据id查询员工数据
	public ScenicSpot findById(Integer id);
	
	public List<ScenicSpot> findByPid(Integer pid);
	
	// 更新员工数据
	public void update(ScenicSpot sces);
	
	// 根据id删除员工数据
	public void deleteById(Integer id);
	
	// 根据名字查询
	public ScenicSpot findByName(String name);
	
	// 获取表中数据总条数
	public int count();
	
	public int count(String name , String city);
	
	// 分页查询
	public List<ScenicSpot> findByIndexAndSize(int index, int size);
	
	//根据景区名城市模糊查询
	public List<ScenicSpot> findLikeByNameAndCity(String name, String city,int index , int size);

}
