package com.wuliu.fa.mapper;

import java.util.List;

import com.wuliu.fa.entity.Companier;

/**
 * 测试公司接口
 * @author Admin
 *
 */
public interface CompanyMapper {
	/**
	 * 查询所有公司
	 * @return
	 */
	List<Companier> findAll();
}
