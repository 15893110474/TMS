package com.xxu.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.xxu.dao.ScenicSpotDao;
import com.xxu.dao.impl.ScenicSpotImpl;
import com.xxu.entity.ScenicSpot;
import com.xxu.services.ScenicSpotService;
import com.xxu.vo.PageBean;

public class ScenicSpotServiceImpl implements ScenicSpotService {

	private ScenicSpotDao ssd = new ScenicSpotImpl();
	@Override
	public String addScenicSpot(ScenicSpot ss) {
		// TODO Auto-generated method stub
		if (ss == null) {
			return "景区内容不能为空";
		}
		
		ScenicSpot scenicSpot = ssd.findByName(ss.getName());
		if (scenicSpot == null) {
			ssd.add(ss);
		} else {
			return "已有同名景区，请更名";
		}
		return "添加成功";
	}

	@Override
	public String deleteScenicSpotById(Integer id) {
		// TODO Auto-generated method stub
		if (id != null && id > 0) {
			ssd.deleteById(id);
		} else {
			return "ID错误";
		}
		return "删除成功";
	}

	@Override
	public String updateScenicSpot(ScenicSpot ScenicSpot) {
		// TODO Auto-generated method stub
		return "更新成功";
	}

	@Override
	public List<ScenicSpot> findAllScenicSpot() {
		// TODO Auto-generated method stub
		List<ScenicSpot> list = ssd.findAll();
		return list;
	}

	@Override
	public ScenicSpot findScenicSpotById(Integer id) {
		// TODO Auto-generated method stub
		ScenicSpot ss = null;
		if (id != null && id > 0) {
			ss = ssd.findById(id);
		} else {
			throw new RuntimeException("ID错误");
		}
		
		return ss;
	}
	
	@Override
	public List<ScenicSpot> findScenicSpotByPid(Integer id) {
		// TODO Auto-generated method stub
		List<ScenicSpot> list = new ArrayList<ScenicSpot>();
		if (id != null && id > 0) {
			list = ssd.findByPid(id);
		} else {
			throw new RuntimeException("ID错误");
		}
		
		return list;
	}
	
	public ScenicSpot findScenicSpotByName(String name) {
		ScenicSpot ss = new ScenicSpot();
		if (name != null && !name.equals("")){
			ss = ssd.findByName(name);
		} else {
			throw new RuntimeException("失败");
		}
		return ss;
	}

	@Override
	public PageBean<ScenicSpot> findScenicSpotByPage(int page) {
		// TODO Auto-generated method stub
		PageBean<ScenicSpot> pageBean = new PageBean<>();
		
		// 获取员工表中的总记录数
		int count = ssd.count();
		int total = 0;
		// 计算总页数
		if(count % pageBean.getPageSize() == 0){
			total = count / pageBean.getPageSize();
		}else{
			total = count / pageBean.getPageSize() + 1;
		}
		pageBean.setTotalPage(total);
		pageBean.setCurrentPage(page);
		
		// 计算分页使用的索引
		int index = (page - 1) * pageBean.getPageSize();
		// 分页查询
		List<ScenicSpot> list = ssd.findByIndexAndSize(index, pageBean.getPageSize());
		pageBean.setPageInfos(list);
		
		return pageBean; 
	}
	
	public PageBean<ScenicSpot> search(String name , String city , int page){
		PageBean<ScenicSpot> pageBean = new PageBean<>();
		
		// 获取员工表中的总记录数
		int count = ssd.count(name , city);
		int total = 0;
		// 计算总页数
		if(count % pageBean.getPageSize() == 0){
			total = count / pageBean.getPageSize();
		}else{
			total = count / pageBean.getPageSize() + 1;
		}
		pageBean.setTotalPage(total);
		pageBean.setCurrentPage(page);
		
		// 计算分页使用的索引
		int index = (page - 1) * pageBean.getPageSize();
		// 分页查询
		List<ScenicSpot> list = ssd.findLikeByNameAndCity(name, city,index, pageBean.getPageSize());
		pageBean.setPageInfos(list);
		
		return pageBean; 		
		
	}

}
