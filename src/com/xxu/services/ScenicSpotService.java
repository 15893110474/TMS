package com.xxu.services;

import java.util.List;

import com.xxu.entity.ScenicSpot;
import com.xxu.vo.PageBean;

public interface ScenicSpotService {
	public String addScenicSpot(ScenicSpot ScenicSpot);
	
	public String deleteScenicSpotById(Integer id);
	
	public String updateScenicSpot(ScenicSpot  ScenicSpot);
	
	public List<ScenicSpot> findAllScenicSpot();
	
	public ScenicSpot findScenicSpotById(Integer id);
	
	public List<ScenicSpot> findScenicSpotByPid(Integer pid);
	
	public ScenicSpot findScenicSpotByName(String id);
	
	// 进行分页查询
	public PageBean<ScenicSpot> findScenicSpotByPage(int page);
	
	public PageBean<ScenicSpot> search(String name , String city , int page);
}
