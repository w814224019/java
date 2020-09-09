package com.wuliu.fa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuliu.fa.entity.area;

public interface areaMapper {
	/**
	 * 根据省查询下级
	 */
	List<area> findByshengxi(@Param("shengxid")Integer shengxid,@Param("js")Integer js);	
	/**
	 * 查找区
	 */
	List<area> findByxiao(@Param("xiaoxian")Integer xiaoxian,@Param("js")Integer js);
	/**
	 * 根据当前id返回城市
	 */
	area findByid(Integer id);
	/**
	 * 根据当前id查找下级列表
	 */
	List<area> findxia(Integer id);
	
	/**
	 * 查询省下面市 js=1 地级市 js=2 区 js=3乡镇
	 */
	List<area> finddijishi(@Param("id")Integer id,@Param("js")Integer js);
}
