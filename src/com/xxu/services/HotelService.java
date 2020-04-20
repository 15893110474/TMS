package com.xxu.services;

import java.util.List;

import com.xxu.entity.Hotel;

public interface HotelService {
	
	public List<Hotel> findBySid(Integer id);
	public String addHotel(Hotel h);
	public Hotel findById(Integer id);
	
}
