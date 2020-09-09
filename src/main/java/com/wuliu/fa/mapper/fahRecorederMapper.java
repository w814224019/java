package com.wuliu.fa.mapper;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.wuliu.fa.entity.fahRecoreder;

public interface fahRecorederMapper {
	/**
	 * 根据公司id查询发货记录
	 */
	Page<fahRecoreder> findhRecorderBycoi(Integer companyid);
	 /***
     * 添加发货订单信息
     */
    Integer addOrder(fahRecoreder shipmentsOrder);
	/**
	 * 首页查询货源
	 */
	Page<fahRecoreder> findAfdhRecorders();

	/**
	 * 根据用户id查询货源信息
	 */
	fahRecoreder findByid(Integer id);
	/**
	 * 根据用户id分页查询所有发货记录
	 */
	Page<fahRecoreder> findAfdhRecorder(@Param("name")String name,@Param("userid")Integer userid);

	/**
	 * 根据发货人id查询发货记录
	 */

	Page<fahRecoreder> findAfdhRecorderByi(Integer rid);
	/**
	 * 根据发货状态查询发货记录
	 */

	Page<fahRecoreder> findAfdhRecorderBystatus(String status);

}
