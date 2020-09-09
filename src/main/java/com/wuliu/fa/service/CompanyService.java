package com.wuliu.fa.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.wuliu.fa.entity.Companier;
import com.wuliu.fa.entity.company;
import com.wuliu.fa.entity.compxingx;


public interface CompanyService {
	/**
	 * 公司刷新排名
	 */
	Integer IUpcomorder(Integer id,Integer wlbi);
	/**
	 * 根据name查找公司资料
	 */
	company Getbyname(String name);
	/**
	 * 添加物流公司
	 */
	Integer saveCompany(company c);
	/**
	 * 根据公司id查找公司轮播图
	 * 
	 */
	List<compxingx> Getxings(Integer sid);
	/**
	 * 本地优质企业放入缓存
	 */
	Page<company> youzhicom(Integer xian1);
	/**
	 * 根据公司名称模糊查找公司信息
	 */
	Page<company> GetBycname(String name,Integer pageSize,Integer pageNum);
	/**
	 * 根据公司出发地查询三方货代
	 */
	Page<company> getBycnz(Integer xian1,Integer pageSize,Integer pageNum,Integer zhengche);
	/**
	 * 根据公司id查询公司详情
	 */
	company getById(Integer id);
	/**
	 * 根据公司出发地查询
	 */
	Page<company> getBycn(Integer xian1,Integer zhengche,Integer pageSize,Integer pageNum);
	/**
	 * 查询公司所有信息
	 * @return
	 */
	List<Companier> findAllCompany();
}
