package com.wuliu.fa.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 后台用户实体类
 * @author Admin
 *
 */


public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	//序号
	private Integer rid;
	//用户名
	private String name;
	//密码
	private String password;
	//companyid 公司id
	private Integer companyid;
	//出发地   id
	private Integer branchid;
	//注册用手机号
	private String mobile;
	//会员类型
	private String permissionid;
	//公司名
	private String company;
	//出发地
	private String city;
	//地址
	private String address;
	//用户状态 0 为正常     1为废除
	private Integer delFlag;
	//主图
	private String headimgurl;
	//类别；1物流公司,2车主，3发货企业或个人，4，配货信息部，5国际物流企业，6快递公司，7搬家公司，
	//8物流设备企业，9物流园区，10停车场，默认为100是只注册而未填写任何信息的账户
	private Integer type;
    //注册时间
	private Date add_time;
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getCompanyid() {
		return companyid;
	}
	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}
	public Integer getBranchid() {
		return branchid;
	}
	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPermissionid() {
		return permissionid;
	}
	public void setPermissionid(String permissionid) {
		this.permissionid = permissionid;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
	public Integer getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	@Override
	public String toString() {
		return "User [rid=" + rid + ", name=" + name + ", password=" + password + ", companyid=" + companyid
				+ ", branchid=" + branchid + ", mobile=" + mobile + ", permissionid=" + permissionid + ", company="
				+ company + ", city=" + city + ", address=" + address + ", delFlag=" + delFlag + ", headimgurl="
				+ headimgurl + ", type=" + type + ", add_time=" + add_time + "]";
	}
	

}
