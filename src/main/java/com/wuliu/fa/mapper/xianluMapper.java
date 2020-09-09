package com.wuliu.fa.mapper;


import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.wuliu.fa.entity.company;

public interface xianluMapper {
/**
 * 根据keywords查询公司列表
 */
	Page<company> findBykey(String keywrods);
	/**
	 * 根据出发地到达地id号查询公司列表
	 */
	Page<company> findBycd(@Param("cfd")Integer cfd,@Param("ddd")Integer ddd,@Param("page")Integer page,@Param("pageSize")Integer pageSize);

}
