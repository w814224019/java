package com.wuliu.fa.service;

import java.util.List;

import com.wuliu.fa.entity.goodstype;
import com.wuliu.fa.entity.lgoodstype;

public interface goodstypeService {
/**
 * 获取所有
 */
	List<lgoodstype> GetAllgt();
	/**
	 * 根据id查询
	 */
	goodstype getByid(Integer id);
}
