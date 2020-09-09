package com.wuliu.fa.entity;


/**
 * 地区实体类
 * @author Admin
 *
 */
public class area extends BaseEntity {

private static final long serialVersionUID = 1L;
//自己的id
private Integer id;
//当前的地名
private String xname;
//上级id
private Integer xiaoxian;
//上级地名
private String cname;
//市id
private Integer shiid;
//市名称
private String shiname;
//省名称
private String shengname;
//省
private Integer sheng;
//省线路id
private Integer shengxid;
//拼音简称
private String pyjc;
//全名
private String quanming;
//级别
private Integer js;
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
public Integer getXiaoxian() {
	return xiaoxian;
}
public void setXiaoxian(Integer xiaoxian) {
	this.xiaoxian = xiaoxian;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public Integer getShiid() {
	return shiid;
}
public void setShiid(Integer shiid) {
	this.shiid = shiid;
}
public String getShiname() {
	return shiname;
}
public void setShiname(String shiname) {
	this.shiname = shiname;
}
public String getShengname() {
	return shengname;
}
public void setShengname(String shengname) {
	this.shengname = shengname;
}
public Integer getSheng() {
	return sheng;
}
public void setSheng(Integer sheng) {
	this.sheng = sheng;
}
public Integer getShengxid() {
	return shengxid;
}
public void setShengxid(Integer shengxid) {
	this.shengxid = shengxid;
}
public String getPyjc() {
	return pyjc;
}
public void setPyjc(String pyjc) {
	this.pyjc = pyjc;
}
public String getQuanming() {
	return quanming;
}
public void setQuanming(String quanming) {
	this.quanming = quanming;
}
public Integer getJs() {
	return js;
}
public void setJs(Integer js) {
	this.js = js;
}
@Override
public String toString() {
	return "area [id=" + id + ", xname=" + xname + ", xiaoxian=" + xiaoxian + ", cname=" + cname + ", shiid=" + shiid
			+ ", shiname=" + shiname + ", shengname=" + shengname + ", sheng=" + sheng + ", shengxid=" + shengxid
			+ ", pyjc=" + pyjc + ", quanming=" + quanming + ", js=" + js + "]";
}

}
