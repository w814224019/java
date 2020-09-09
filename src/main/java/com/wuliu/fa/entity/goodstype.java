package com.wuliu.fa.entity;

import java.io.Serializable;

public class goodstype implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    //主键 id
	private Integer id;
	//名称
	private String name;
	//拼音
	private String pinyin;
	//级别
	private Integer typeid;
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
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	@Override
	public String toString() {
		return "goodstype [id=" + id + ", name=" + name + ", pinyin=" + pinyin + ", typeid=" + typeid + "]";
	}
	

	
}
