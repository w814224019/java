package com.wuliu.fa.entity;

import java.io.Serializable;
import java.util.List;

public class lgoodstype implements Serializable {
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
		private List<goodstype> slist;
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
		public List<goodstype> getSlist() {
			return slist;
		}
		public void setSlist(List<goodstype> slist) {
			this.slist = slist;
		}
		@Override
		public String toString() {
			return "lgoodstype [id=" + id + ", name=" + name + ", pinyin=" + pinyin + ", typeid=" + typeid + ", slist="
					+ slist + "]";
		}
		
}
