package com.xxu.entity;
/**
 * 附近宾馆
 * @author Administrator
 *
 */
public class Hotel {
	
	private Integer id;
	private Integer sId;//景区ID
	private String name;
	private String introduce;
	//客房类型
	private String type;
	//价格
	private Integer price;
	private String address; 
	private String imgUrl;
	
	public Hotel() {
	}

	public Hotel(Integer id, Integer sId, String name, String introduce, String type, Integer price, String address,
			String imgUrl) {
		this.id = id;
		this.sId = sId;
		this.name = name;
		this.introduce = introduce;
		this.type = type;
		this.price = price;
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
		return sId;
	}

	public void setSId(Integer sId) {
		this.sId = sId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
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
		return "Hotel [id=" + id + ", sId=" + sId + ", name=" + name + ", introduce=" + introduce + ", type=" + type
				+ ", price=" + price + ", address=" + address + ", imgUrl=" + imgUrl + "]";
	}
	
}
