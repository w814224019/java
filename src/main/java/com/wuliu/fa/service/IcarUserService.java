package com.wuliu.fa.service;

import com.github.pagehelper.Page;
import com.wuliu.fa.entity.carUser;

public interface IcarUserService {
	/**
	 * 根据车主id查询车辆信息
	 * 
	 */
	carUser getcarUserByi(Integer id);
	/**
	 * 主页分页查询车源
	 */
	Page<carUser> getcarusers(Integer pageNum,Integer pageSize);
	/**
	 * 发布车源
	 */
    Integer Sadd(carUser carr);
}
