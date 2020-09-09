package com.wuliu.fa.service;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.wuliu.fa.entity.company;

public interface xianluService {
	/**
	 * 根据keywords查询公司列表
	 */
		Page<company> getcompBykey(Integer pageNum,Integer pageSize,String keywrods);
	/**
	 * 根据出发地到达地id号查询公司列表
	 */
	Page<company> GetcompBycd(Integer pageNum,Integer pageSize,@Param("cfd")Integer cfd,@Param("ddd")Integer ddd);
}
