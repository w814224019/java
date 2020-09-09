package com.wuliu.fa.entity;

import java.io.Serializable;

public class tui implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//主键
	private Integer id;
	//公司id
	private Integer sid;
	//出发地id
	private Integer xian1;
	//关键词id
	private Integer gid;
	//出发地城市
	private String xiancn;
	//关键词名称
	private String gname;
	//公司简称
	private String gsjc;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getXian1() {
		return xian1;
	}
	public void setXian1(Integer xian1) {
		this.xian1 = xian1;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getXiancn() {
		return xiancn;
	}
	public void setXiancn(String xiancn) {
		this.xiancn = xiancn;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGsjc() {
		return gsjc;
	}
	public void setGsjc(String gsjc) {
		this.gsjc = gsjc;
	}
	@Override
	public String toString() {
		return "tui [id=" + id + ", sid=" + sid + ", xian1=" + xian1 + ", gid=" + gid + ", xiancn=" + xiancn
				+ ", gname=" + gname + ", gsjc=" + gsjc + "]";
	}
	
}
