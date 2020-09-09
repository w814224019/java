package com.wuliu.fa.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wuliu.fa.entity.carUser;
import com.wuliu.fa.mapper.carUserMapper;
import com.wuliu.fa.service.IcarUserService;

@Service
public class carUserServiceImp implements IcarUserService{
  @Autowired
  carUserMapper carusermapper;
	@Override
	public Page<carUser> getcarusers(Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<carUser> carUserlist=carusermapper.findcarusers();
		return carUserlist;
	}
	@Override
	public carUser getcarUserByi(Integer id) {
		carUser c=carusermapper.findAcarUserByi(id);
		return c;
	}
	@Override
	public Integer Sadd(carUser carr) {
		 Integer S=carusermapper.add(carr);
		return S;
	}

}
