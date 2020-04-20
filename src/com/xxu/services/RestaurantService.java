package com.xxu.services;

import java.util.List;

import com.xxu.entity.Restaurant;

public interface RestaurantService {
	
	public List<Restaurant> findBySid(Integer id);
	public String addRestaurant(Restaurant r);
	public Restaurant findById(Integer id);
}
