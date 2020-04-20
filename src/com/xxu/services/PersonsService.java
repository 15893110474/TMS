package com.xxu.services;

import java.util.List;

import com.xxu.entity.Persons;
import com.xxu.vo.PageBean;

// 业务层定义的方法，根据功能决定
public interface PersonsService {
	
	public void addPerson(Persons person);
	
	public void deletePersonById(Integer id);
	
	public void updatePerson(Persons  person);
	
	public List<Persons> findAllPerson();
	
	public Persons findPersonById(Integer id);
	
	public Persons login(String username , String password);
	
	// 进行分页查询
	public PageBean<Persons> findPersonByPage(int page);
	
}
