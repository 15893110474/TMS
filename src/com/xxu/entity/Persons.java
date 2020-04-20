package com.xxu.entity;
/**
 * 人员信息（已注册的）
 * @author Administrator
 *
 */
public class Persons {
	// 使用包装类型
	private Integer id;
	private String name;
	private String sex;
	private Integer age;
	private String phone;
	private String username;
	private String password;
	private Integer admin;
	public Persons(){}	
	public Persons(Integer id, String name, String sex, Integer age, String phone,String username,String password){
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.admin = 0;
	}	
	public Integer getAdmin() {
		return admin;
	}
	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "persons [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", phone=" + phone
				+ ", username=" + username + ", password=" + password + "]";
	}	
}
