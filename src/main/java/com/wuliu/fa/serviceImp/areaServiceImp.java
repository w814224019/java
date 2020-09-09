package com.wuliu.fa.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuliu.fa.config.RedisUtil;
import com.wuliu.fa.entity.alist;
import com.wuliu.fa.entity.area;
import com.wuliu.fa.mapper.areaMapper;
import com.wuliu.fa.service.areaService;
import com.wuliu.fa.util.Constant;

@Service
public class areaServiceImp implements areaService{
   @Autowired
   areaMapper areamapper;
   @Autowired
	 private RedisUtil redisUtil;
	@Override
	public List<area> getxia(Integer id) {
		List<area> s=areamapper.findxia(id);
		return s;
	}

	@Override
	public List<area> getdijishi(Integer id, Integer js) {
		List<area> f=areamapper.finddijishi(id, js);
		return f;
	}

	@Override
	public area GetdByid(Integer id) {
	area a=areamapper.findByid(id);
		return a;
	}

	@Override
	public List<alist>  GetByxiao() {
		List<alist> al=new ArrayList<alist>();
		String arr[]=Constant.cityArray1;
		String key="sone";
		if(redisUtil.hasKey(key)){
			al=(List<alist>) redisUtil.get(key);	
		}else{
			for (int j = 0; j < arr.length; j++) {
				String ar[]=arr[j].split("_");
				alist a=new alist ();
				a.setXname(ar[0]);
				a.setId(Integer.parseInt(ar[1]));
				List<area> GetB=areamapper.findByshengxi(Integer.parseInt(ar[1]), 2);
				a.setLia(GetB);
				al.add(a);
			}
			redisUtil.set(key,al,43200);
		}
		
		return al;
	}

	@Override
	public List<area> GetByshengxi(Integer shengxid, Integer js) {
		List<area> GetByshen=areamapper.findByshengxi(shengxid, js);
		return GetByshen;
	}

	@Override
	public List<alist> GetByshengxid(Integer shengxid) {
		List<alist> al=new ArrayList<alist>();
		String key="sheng"+shengxid;
		if(redisUtil.hasKey(key)){
			al=(List<alist>) redisUtil.get(key);
		}else{
			//市
			List<area> GetB=areamapper.findByshengxi(shengxid, 1);
			for (area area : GetB) {
				//区
				List<area> Getc=areamapper.findxia(area.getId());
				alist a=new alist ();
				a.setId(area.getId());
				a.setXname(area.getXname());
				a.setLia(Getc);
				al.add(a);
			}
			redisUtil.set(key,al,43200);
		}
		
		return al;
	}

}
