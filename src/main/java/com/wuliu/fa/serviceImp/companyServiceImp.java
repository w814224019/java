package com.wuliu.fa.serviceImp;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wuliu.fa.config.RedisUtil;
import com.wuliu.fa.entity.Companier;
import com.wuliu.fa.entity.company;
import com.wuliu.fa.entity.compxingx;
import com.wuliu.fa.mapper.CompanyMapper;
import com.wuliu.fa.mapper.CompanyMapper2;
import com.wuliu.fa.service.CompanyService;

@Service
public class companyServiceImp implements CompanyService{
    @Autowired
    CompanyMapper companyservice;
    @Autowired
    CompanyMapper2 companyservice2;
    @Autowired
	 private RedisUtil redisUtil;
	@Override
	public List<Companier> findAllCompany() {
		List<Companier> companylist=companyservice.findAll();
		return companylist;
	}
	@Override
	public Page<company> getBycn(Integer xian1, Integer zhengche, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum,pageSize);
		Page<company> companypage=companyservice2.findBycn(xian1, zhengche);
		return companypage;
	}
	@Override
	public company getById(Integer id) {
		company c=companyservice2.findByid(id);
		return c;
	}
	@Override
	public Page<company> getBycnz(Integer xian1, Integer pageSize, Integer pageNum,Integer  zhengche) {
		PageHelper.startPage(pageNum,pageSize);
		Page<company> companypages=companyservice2.findBycnz(xian1,zhengche);
		return companypages;
	}
	@Override
	public Page<company> GetBycname(String name, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum,pageSize);
		Page<company> companypages=companyservice2.findBycname(name);
		return companypages;
	}
	@Override
	public Page<company> youzhicom(Integer xian1) {
		Page<company> companypages=new Page<company> ();
		if(redisUtil.hasKey("yzcomp"+xian1)){
			companypages=(Page<company>) redisUtil.get("yzcomp"+xian1);
		}else{
			
			PageHelper.startPage(1,6);
			 companypages=companyservice2.findBycnz(xian1,0);
			 redisUtil.set("yzcomp"+xian1, companypages, 36000);
		}
		return companypages;
	}
	@Override
	public List<compxingx> Getxings(Integer sid) {
		List<compxingx> Getx=companyservice2.findxings(sid);
		return Getx;
	}
	@Override
	public Integer saveCompany(company c) {
		Integer saveCo=companyservice2.addCompany(c);
		return saveCo;
	}
	@Override
	public company Getbyname(String name) {
		company Getby=companyservice2.findbyname(name);
		return Getby;
	}
	@Override
	public Integer IUpcomorder(Integer id,Integer wlbi) {
		Integer IUpc=companyservice2.Upcomorder(System.currentTimeMillis(),wlbi, id);
		return IUpc;
	}

}

