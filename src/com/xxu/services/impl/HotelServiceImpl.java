package com.xxu.services.impl;

import java.util.List;

import com.xxu.dao.HotelDao;
import com.xxu.dao.impl.HotelDaoImpl;
import com.xxu.entity.Hotel;
import com.xxu.entity.ScenicSpot;
import com.xxu.services.HotelService;

public class HotelServiceImpl implements HotelService {
	private HotelDao hd = new HotelDaoImpl();
	@Override
	public List<Hotel> findBySid(Integer id) {
		// TODO Auto-generated method stub
		List<Hotel> list = null;
		if (id != null && id >0) {
			hd.findBySid(id);
		}
		return list;
	}

	@Override
	public String addHotel(Hotel h) {
		// TODO Auto-generated method stub
		if (h == null) {
			return "宾馆内容不能为空";
		}
		
		Hotel ht = hd.findByName(h.getName());
		if (ht == null) {
			hd.add(h);
		} else {
			return "该景区附近已有同名宾馆，请添加标识加以区分分";
		}
		return "添加成功";
	}

	@Override
	public Hotel findById(Integer id) {
		// TODO Auto-generated method stub
		Hotel h = null;
		if (id != null && id > 0) {
			h = hd.findById(id);
		}
		return h;
	}

	
	
}
