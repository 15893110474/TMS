package com.xxu.entity;
/**
 * 附近饭馆
 * @author Administrator
 *
 */
public class Restaurant {
	private Integer id;
	private Integer SId;
	private String name;
	private String introduce;
	private Integer consumption;
	private String address;
	private String imgUrl;
	public Restaurant() {
	}
	public Restaurant(Integer id, Integer sId, String name, String introduce, Integer consumption, String address,
			String imgUrl) {
		this.id = id;
		this.SId = sId;
		this.name = name;
		this.introduce = introduce;
		this.consumption = consumption;
		this.address = address;
		this.imgUrl = imgUrl;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSId() {
		return SId;
	}
	public void setSId(Integer sId) {
		this.SId = sId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Integer getConsumption() {
		return consumption;
	}
	public void setConsumption(Integer consumption) {
		this.consumption = consumption;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", SId=" + SId + ", name=" + name + ", introduce=" + introduce
				+ ", consumption=" + consumption + ", address=" + address + ", imgUrl=" + imgUrl + "]";
	}
	
	
	
}
