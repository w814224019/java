package com.wuliu.fa.entity;

import java.io.Serializable;

public class compxingx implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   //主键 id
	private Integer id;
	//公司id
	private Integer sid;
	//公司图片路径
	private String pic;
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
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "compxingx [id=" + id + ", sid=" + sid + ", pic=" + pic + "]";
	}
	
}
