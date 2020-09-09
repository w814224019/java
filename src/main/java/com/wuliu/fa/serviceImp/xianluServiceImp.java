package com.wuliu.fa.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wuliu.fa.annonation.ServiceLimit;
import com.wuliu.fa.entity.company;
import com.wuliu.fa.mapper.xianluMapper;
import com.wuliu.fa.service.xianluService;

@Service
public class xianluServiceImp implements xianluService{
	@Autowired
	xianluMapper xianlumapper;

	@Override
	@ServiceLimit(limitType= ServiceLimit.LimitType.IP)
	public Page<company> GetcompBycd(Integer pageNum, Integer pageSize, Integer cfd, Integer ddd) {
		Page<company> pc=xianlumapper.findBycd(cfd, ddd,pageNum,pageSize);
		return pc;
	}

	@Override
	public Page<company> getcompBykey(Integer pageNum,Integer pageSize,String keywrods) {
		PageHelper.startPage(pageNum, pageSize);
		Page<company> pc=xianlumapper.findBykey(keywrods);
		return pc;
	}

}
