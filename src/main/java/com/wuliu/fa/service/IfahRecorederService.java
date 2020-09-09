package com.wuliu.fa.service;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.wuliu.fa.entity.fahRecoreder;
@Service
public interface IfahRecorederService {
	/**
	 * 根据公司id查询发货记录
	 */
	Page<fahRecoreder> gethRecorderBycoi(Integer pageNum,Integer pageSize,Integer companyid);
	 /***
     * 添加发货订单信息
     */
    Integer addfOrder(fahRecoreder shipmentsOrder);
	/**
	 * 根据用户id查询货源信息
	 */
	fahRecoreder getfaredByid(Integer id);
	/**
	 * 首页查询货源
	 */
	Page<fahRecoreder> GetAfdhRecorders(Integer pageNum,Integer pageSize);
	/**
	 * 分页查询所有发货记录
	 */
	Page<fahRecoreder> GetAfdhRecorder(Integer pageNum,Integer pageSize,String name,Integer userid);
	
/**
 * 根据发货人id查询发货记录
 */
	
	Page<fahRecoreder> GetAfdhRecorderByi(Integer pageNum,Integer pageSize,Integer rid);
	/**
	 * 根据发货状态查询发货记录
	 */
	
	Page<fahRecoreder> GetAfdhRecorderBystatus(Integer pageNum,Integer pageSize,String status);

	
	
	
	
	
	
	
}
