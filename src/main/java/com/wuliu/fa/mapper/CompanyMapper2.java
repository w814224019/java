package com.wuliu.fa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.wuliu.fa.entity.company;
import com.wuliu.fa.entity.compxingx;
/**
 * 56114非会员
 * @author Admin
 *
 */


public interface CompanyMapper2 {
	/**
	 * 公司刷新排名
	 */
	Integer Upcomorder(@Param("shuaxin")long shuaxin,@Param("wlbi")Integer wlbi,@Param("id")Integer id);
	/**
	 * 根据name查找公司资料
	 */
	company findbyname(String name);
	/**
	 * 添加物流公司
	 */
	Integer addCompany(company c);
	/**
	 * 根据公司id查找公司轮播图
	 * 
	 */
	List<compxingx> findxings(Integer sid);
	/**
	 * 根据公司名称模糊查找公司信息
	 */
	Page<company> findBycname(@Param("name")String name);
	/**
	 * 根据地区查询三方货代公司
	 */
	Page<company> findBycnz(@Param("xian1")Integer xian1,@Param("zhengche")Integer zhengche);
	/**
	 * 根据公司id查询公司信息
	 * 
	 */
	company findByid(Integer companyid);
	/**
	 * 根据公司出发地查询
	 */
	Page<company> findBycn(@Param("xian1")Integer xian1,@Param("zhengche")Integer zhengche);
	/**
	 * 查询所有公司
	 * @return
	 */
	List<company> findAll();

	/**
	 * 批量添加
	 */
	
	Integer addPathers(List<company> pa);
	/**
	 * 修改
	 * @param ps
	 * @return
	 */
	Integer updateBatch(@Param("list") List<company> list);
	Integer updateBatch1(@Param("list") List<company> list);
	Integer updateBatch2(@Param("list") List<company> list);
}
