package com.wuliu.fa.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 线路实体类
 * @author Admin
 *
 */
public class xianlu implements Serializable{

	
	private static final long serialVersionUID = 1L;
	//主键id
	private Integer id;
	//公司 sid
	private Integer sid;
	//出发城市
	private String chufadi;
	//到达城市
	private String daodadi;
	//索引词
	private String keywords;
	//出发地 id号
	private Integer cfd;
	//到达地ID号
	private Integer ddd;
	//公司类型
	private Integer zhengche; 
	//刷新时间
	private Date sxtime;
	//省份
	private String shengcn;
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
	public String getChufadi() {
		return chufadi;
	}
	public void setChufadi(String chufadi) {
		this.chufadi = chufadi;
	}
	public String getDaodadi() {
		return daodadi;
	}
	public void setDaodadi(String daodadi) {
		this.daodadi = daodadi;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Integer getCfd() {
		return cfd;
	}
	public void setCfd(Integer cfd) {
		this.cfd = cfd;
	}
	public Integer getDdd() {
		return ddd;
	}
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}
	public Integer getZhengche() {
		return zhengche;
	}
	public void setZhengche(Integer zhengche) {
		this.zhengche = zhengche;
	}
	public Date getSxtime() {
		return sxtime;
	}
	public void setSxtime(Date sxtime) {
		this.sxtime = sxtime;
	}
	public String getShengcn() {
		return shengcn;
	}
	public void setShengcn(String shengcn) {
		this.shengcn = shengcn;
	}
	@Override
	public String toString() {
		return "xianlu [id=" + id + ", sid=" + sid + ", chufadi=" + chufadi + ", daodadi=" + daodadi + ", keywords="
				+ keywords + ", cfd=" + cfd + ", ddd=" + ddd + ", zhengche=" + zhengche + ", sxtime=" + sxtime
				+ ", shengcn=" + shengcn + "]";
	}
 

}
