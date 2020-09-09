package com.wuliu.fa.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wuliu.fa.entity.alist;
import com.wuliu.fa.entity.area;

public interface areaService {
	/**
	 * 查询省市区
	 */
	List<alist> GetByshengxid(Integer shengxid);
	/**
	 * 根据省查询下级
	 */
	List<area> GetByshengxi(@Param("shengxid")Integer shengxid,@Param("js")Integer js);
	/**
	 * 查找区
	 */
	List<alist> GetByxiao();
	/**
	 * 根据当前id返回城市
	 */
	area GetdByid(Integer id);
	/**
	 * 根据当前id查找下级列表
	 */
	List<area> getxia(Integer id);
	
	/**
	 * 查询省下面市 js=1 地级市 js=2 区 js=3乡镇
	 */
	List<area> getdijishi(@Param("id")Integer id,@Param("js")Integer js);
}
