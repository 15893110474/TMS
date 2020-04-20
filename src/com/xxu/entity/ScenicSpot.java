package com.xxu.entity;

public class ScenicSpot {

	private Integer id;
	private String name;
	private String city;
	private String address;
	//tedian 
	private String characteristic;
	private String imgUrl;
	private String introduce;
	private String imgUrl2;
	//xiaofei
	private Integer consumption;
	//添加人
	private Integer pId;
	public ScenicSpot() {
	}
	public ScenicSpot(String name, String city, String address, String introduce, String imgUrl,
			String characteristic, String imgUrl2, Integer consumption) {
		this.name = name;
		this.city = city;
		this.address = address;
		this.introduce = introduce;
		this.imgUrl = imgUrl;
		this.characteristic = characteristic;
		this.imgUrl2 = imgUrl2;
		this.consumption = consumption;
		this.pId = 1;//设定为只有一个用户可以添加，admin用户。
	}
	public ScenicSpot(Integer id, String name, String city, String address, String introduce, String imgUrl,
			String introduce2, String imgUrl2, Integer consumption, Integer pId) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.address = address;
		this.introduce = introduce;
		this.imgUrl = imgUrl;
		this.characteristic = introduce2;
		this.imgUrl2 = imgUrl2;
		this.consumption = consumption;
		this.pId = pId;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCharacteristic() {
		return characteristic;
	}
	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getImgUrl2() {
		return imgUrl2;
	}
	public void setImgUrl2(String imgUrl2) {
		this.imgUrl2 = imgUrl2;
	}
	public Integer getConsumption() {
		return consumption;
	}
	public void setConsumption(Integer consumption) {
		this.consumption = consumption;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	@Override
	public String toString() {
		return "Scenic_spot [id=" + id + ", name=" + name + ", city=" + city + ", address=" + address + ", characteristic="
				+ characteristic + ", imgUrl=" + imgUrl + ", introduce=" + introduce + ", imgUrl2=" + imgUrl2
				+ ", consumption=" + consumption + ", pId=" + pId + "]";
	}
	
}
