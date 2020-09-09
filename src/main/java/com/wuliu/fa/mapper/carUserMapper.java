package com.wuliu.fa.mapper;


import com.github.pagehelper.Page;
import com.wuliu.fa.entity.carUser;

public interface carUserMapper {
	/**
	 * 主页分页查询车源
	 */
	Page<carUser> findcarusers();

	/**
	 * 根据车主id查询车辆信息
	 * 
	 */
	carUser findAcarUserByi(Integer id);
	/**
	 * 发布车源
	 */
    Integer add(carUser carr);
}
