package com.wuliu.fa.entity;

import java.io.Serializable;
import java.util.Date;

public class carUser implements Serializable {
	private static final long serialVersionUID = 1L;
	//序号，主键
	private Integer id;
	//用户id
	private Integer userid;
	//联系人
	private String lianxiren;
	//司机电话
	private String phone;
	//汽车类型
	private String type;
	//车长，单位：米
	private String chang;
	//所在城市
	private String city;
	//所在城市 id
	private Integer xian1;
	//目的地
	private String destination;
	//车牌号
	private String carLicense;
	//备注
	private String remark;
	//车辆状态
	private String status;
	
	//图片地址，驾照，行车证
	private String picturePath;
	//添加时间
	private Date addtime;
	//总页数
	private Integer pages;
	//总条数
	private long totals;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getLianxiren() {
		return lianxiren;
	}
	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getChang() {
		return chang;
	}
	public void setChang(String chang) {
		this.chang = chang;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getXian1() {
		return xian1;
	}
	public void setXian1(Integer xian1) {
		this.xian1 = xian1;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getCarLicense() {
		return carLicense;
	}
	public void setCarLicense(String carLicense) {
		this.carLicense = carLicense;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public long getTotals() {
		return totals;
	}
	public void setTotals(long totals) {
		this.totals = totals;
	}
	@Override
	public String toString() {
		return "carUser [id=" + id + ", userid=" + userid + ", lianxiren=" + lianxiren + ", phone=" + phone + ", type="
				+ type + ", chang=" + chang + ", city=" + city + ", xian1=" + xian1 + ", destination=" + destination
				+ ", carLicense=" + carLicense + ", remark=" + remark + ", status=" + status + ", picturePath="
				+ picturePath + ", addtime=" + addtime + ", pages=" + pages + ", totals=" + totals + "]";
	}
	
}
