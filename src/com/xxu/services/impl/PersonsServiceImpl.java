package com.xxu.services.impl;

import java.util.List;

import javax.servlet.http.Cookie;

import com.xxu.dao.PersonsDao;
import com.xxu.dao.impl.PersonsDaoImpl;
import com.xxu.entity.Persons;
import com.xxu.services.PersonsService;
import com.xxu.vo.PageBean;
// 业务层调用数据访问层
public class PersonsServiceImpl implements PersonsService{

	// 创建数据访问层的对象
	private PersonsDao personDao = new PersonsDaoImpl();
	
	@Override
	public void addPerson(Persons Person) {
		// TODO Auto-generated method stub
	
		if(Person == null){
			throw new RuntimeException("员工内容不能为空");
		}
		
		// 登录名相同不能添加，昵称可以相同
		try {
			Persons Personloyee = personDao.findByUserName(Person.getUsername());
			if(Personloyee == null){
				personDao.add(Person);
			}else{
				throw new RuntimeException("员工已存在，不能添加");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Override
	public void deletePersonById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePerson(Persons Person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Persons> findAllPerson() {
		// TODO Auto-generated method stub
		
		List<Persons> list = null;
		try {
			list = personDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			// 抛出异常，由控制层统一处理
			throw new RuntimeException(e.getMessage());
		}
		
		return list;
	}

	@Override
	public Persons findPersonById(Integer id) {
		// TODO Auto-generated method stub
		if (id == null)
			return null;
		Persons p = personDao.findById(id);
		return p;
	}

	@Override
	public PageBean<Persons> findPersonByPage(int page) {
		// TODO Auto-generated method stub
		
		PageBean<Persons> pageBean = new PageBean<>();
		
		// 获取员工表中的总记录数
		int count = personDao.count();
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
		List<Persons> list = personDao.findByIndexAndSize(index, pageBean.getPageSize());
		pageBean.setPageInfos(list);
		
		return pageBean;
	}

	@Override
	public Persons login(String username, String password) {
		// TODO Auto-generated method stub
		Persons person = null;
		person = personDao.findByUserName(username);
		if(person != null) {
			if(!person.getPassword().equals(password)) {
				return null;
			} else {
				return person;
			}
		} else {
			return null;
		}
	}
}
