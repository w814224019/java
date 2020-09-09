package com.wuliu.fa.entity;

import java.io.Serializable;
/**
 * 56114公司实体类
 * @author Admin
 *
 */
public class company implements Serializable{

	private static final long serialVersionUID = 1L;
	//主键id
	private Integer id;
	//公司名称
	private String ctoname;
	//公司地址ַ
	private String xxaddress;
	//联系人电话
	private String lianxitel;
	//微信号
	private String wx;
	//公司座机
	private String tel;
	//联系人
	private String lianxiren;
	//主图片地址ַ
	private  String litpic;
	//简称
	private String qianming;
	//出发地
	private String xiancn;
	//出发地id
	private Integer xian1;
	//公司简介
	private String content;
	//业务
	private String ywms;
	//线路
	private String xianlustr;
	//用户名
	private String username;
	//密码
	private String password;
	//会员类别
	private Integer hylx;
    //整车
	private Integer zhengche;
	//省id 号
	private Integer sheng1;
	//省份
	private String shengm;
	//公司类型
	private Integer gslx;
	//用户名
	private String name;
	//刷新毫秒值
	private long shuaxin;
	//物流币
	private Integer wlbi;
	//首页广告位
	private Integer ggw1;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCtoname() {
		return ctoname;
	}
	public void setCtoname(String ctoname) {
		this.ctoname = ctoname;
	}
	public String getXxaddress() {
		return xxaddress;
	}
	public void setXxaddress(String xxaddress) {
		this.xxaddress = xxaddress;
	}
	public String getLianxitel() {
		return lianxitel;
	}
	public void setLianxitel(String lianxitel) {
		this.lianxitel = lianxitel;
	}
	public String getWx() {
		return wx;
	}
	public void setWx(String wx) {
		this.wx = wx;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getLianxiren() {
		return lianxiren;
	}
	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}
	public String getLitpic() {
		return litpic;
	}
	public void setLitpic(String litpic) {
		this.litpic = litpic;
	}
	public String getQianming() {
		return qianming;
	}
	public void setQianming(String qianming) {
		this.qianming = qianming;
	}
	public String getXiancn() {
		return xiancn;
	}
	public void setXiancn(String xiancn) {
		this.xiancn = xiancn;
	}
	public Integer getXian1() {
		return xian1;
	}
	public void setXian1(Integer xian1) {
		this.xian1 = xian1;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getYwms() {
		return ywms;
	}
	public void setYwms(String ywms) {
		this.ywms = ywms;
	}
	public String getXianlustr() {
		return xianlustr;
	}
	public void setXianlustr(String xianlustr) {
		this.xianlustr = xianlustr;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getHylx() {
		return hylx;
	}
	public void setHylx(Integer hylx) {
		this.hylx = hylx;
	}
	public Integer getZhengche() {
		return zhengche;
	}
	public void setZhengche(Integer zhengche) {
		this.zhengche = zhengche;
	}
	public Integer getSheng1() {
		return sheng1;
	}
	public void setSheng1(Integer sheng1) {
		this.sheng1 = sheng1;
	}
	public String getShengm() {
		return shengm;
	}
	public void setShengm(String shengm) {
		this.shengm = shengm;
	}
	public Integer getGslx() {
		return gslx;
	}
	public void setGslx(Integer gslx) {
		this.gslx = gslx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getShuaxin() {
		return shuaxin;
	}
	public void setShuaxin(long shuaxin) {
		this.shuaxin = shuaxin;
	}
	public Integer getWlbi() {
		return wlbi;
	}
	public void setWlbi(Integer wlbi) {
		this.wlbi = wlbi;
	}
	public Integer getGgw1() {
		return ggw1;
	}
	public void setGgw1(Integer ggw1) {
		this.ggw1 = ggw1;
	}
	@Override
	public String toString() {
		return "company [id=" + id + ", ctoname=" + ctoname + ", xxaddress=" + xxaddress + ", lianxitel=" + lianxitel
				+ ", wx=" + wx + ", tel=" + tel + ", lianxiren=" + lianxiren + ", litpic=" + litpic + ", qianming="
				+ qianming + ", xiancn=" + xiancn + ", xian1=" + xian1 + ", content=" + content + ", ywms=" + ywms
				+ ", xianlustr=" + xianlustr + ", username=" + username + ", password=" + password + ", hylx=" + hylx
				+ ", zhengche=" + zhengche + ", sheng1=" + sheng1 + ", shengm=" + shengm + ", gslx=" + gslx + ", name="
				+ name + ", shuaxin=" + shuaxin + ", wlbi=" + wlbi + ", ggw1=" + ggw1 + "]";
	}
	
}
