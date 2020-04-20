package com.xxu.services.impl;

import java.util.List;

import com.xxu.dao.RestaurantDao;
import com.xxu.dao.impl.RestaurantDaoImpl;
import com.xxu.entity.Restaurant;
import com.xxu.services.RestaurantService;

public class RestaurantServiceImpl implements RestaurantService {
	private RestaurantDao rd = new RestaurantDaoImpl();
	@Override
	public List<Restaurant> findBySid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addRestaurant(Restaurant r) {
		// TODO Auto-generated method stub
		if (r == null) {
			return "饭馆内容不能为空";
		}
		
		Restaurant restaurant = rd.findByName(r.getName());
		if (restaurant == null) {
			rd.add(r);
		} else {
			return "该景区附近已有同名饭店，请添加标识加以区分";
		}
		return "添加成功";		
	}

	@Override
	public Restaurant findById(Integer id) {
		// TODO Auto-generated method stub
		if(id == null || id < 0) {
			return null;
		}
		Restaurant restaurant = rd.findById(id);
		return restaurant;
	}

}
