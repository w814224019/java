package com.wuliu.fa.entity;

import java.io.Serializable;
import java.util.List;

public class alist implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//自己的id
	private Integer id;
	//当前的地名
	private String xname;
	private List<area> lia;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getXname() {
		return xname;
	}
	public void setXname(String xname) {
		this.xname = xname;
	}
	public List<area> getLia() {
		return lia;
	}
	public void setLia(List<area> lia) {
		this.lia = lia;
	}
	@Override
	public String toString() {
		return "alist [id=" + id + ", xname=" + xname + ", lia=" + lia + "]";
	}
	
}
