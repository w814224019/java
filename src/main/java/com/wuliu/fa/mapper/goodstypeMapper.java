package com.wuliu.fa.mapper;

import java.util.List;

import com.wuliu.fa.entity.goodstype;

public interface goodstypeMapper {

	/**
	 * 根据一级id查询下级
	 */
	List<goodstype> ngdfind(Integer typeid);
	/**
	 * 根据id查询
	 */
	goodstype findByid(Integer id);
}
