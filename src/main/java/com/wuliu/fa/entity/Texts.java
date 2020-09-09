package com.wuliu.fa.entity;

import java.io.Serializable;
import java.util.Date;

public class Texts implements Serializable{

	private static final long serialVersionUID = 1L;
	//主键
	private Integer id;
	//创建者
	private String creater;
	//操作者
	private String modifiedUser;
	//操作时间
	private Date modifiedTime;
	//调用方法
	private String functions;
	//公司名称
	private String companyName;
	//操作内容
	private String contents;
	//公司id
	private Integer companyId;
	//总页数
	private Integer pages;
	//总条数
	private long totals;
	@Override
	public String toString() {
		return "Texts [id=" + id + ", creater=" + creater + ", modifiedUser=" + modifiedUser + ", modifiedTime="
				+ modifiedTime + ", functions=" + functions + ", companyName=" + companyName + ", contents=" + contents
				+ ", companyId=" + companyId + ", pages=" + pages + ", totals=" + totals + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getFunctions() {
		return functions;
	}
	public void setFunctions(String functions) {
		this.functions = functions;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
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





}
