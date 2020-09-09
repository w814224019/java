package com.wuliu.fa.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wuliu.fa.entity.fahRecoreder;
import com.wuliu.fa.mapper.fahRecorederMapper;
import com.wuliu.fa.service.IfahRecorederService;

@Service
public class fahRecorederServiceImpl implements IfahRecorederService{
	@Autowired
	 fahRecorederMapper fahrMapper;
	
	
	@Override
	public Page<fahRecoreder> GetAfdhRecorder(Integer pageNum,Integer pageSize,String name,Integer userid) {
		PageHelper.startPage(pageNum, pageSize);
		return fahrMapper.findAfdhRecorder(name,userid);
	}

	@Override
	public Page<fahRecoreder> GetAfdhRecorderByi(Integer pageNum,Integer pageSize, Integer rid) {
		PageHelper.startPage(pageNum, pageSize);
		return fahrMapper.findAfdhRecorderByi(rid);
	}

	@Override
	public Page<fahRecoreder> GetAfdhRecorderBystatus(Integer pageNum,Integer pageSize,String status) {
		PageHelper.startPage(pageNum, pageSize);
		return fahrMapper.findAfdhRecorderBystatus(status);
	}

	@Override
	public Page<fahRecoreder> GetAfdhRecorders(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return fahrMapper.findAfdhRecorders();
	}

	@Override
	public fahRecoreder getfaredByid(Integer id) {
		fahRecoreder f=fahrMapper.findByid(id);
		return f;
	}

	@Override
	public Integer addfOrder(fahRecoreder shipmentsOrder) {
		Integer ad=fahrMapper.addOrder(shipmentsOrder);
				
		return ad;
	}

	@Override
	public Page<fahRecoreder> gethRecorderBycoi(Integer pageNum,Integer pageSize,Integer companyid) {
		PageHelper.startPage(pageNum, pageSize);
		Page<fahRecoreder> gethRec=fahrMapper.findhRecorderBycoi(companyid);
		return gethRec;
	}



}
