package com.wuliu.fa.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuliu.fa.entity.goodstype;
import com.wuliu.fa.entity.lgoodstype;
import com.wuliu.fa.mapper.goodstypeMapper;
import com.wuliu.fa.service.goodstypeService;
@Service
public class goodstypeServiceImp implements goodstypeService{
    @Autowired
    goodstypeMapper gsmapper;
	@Override
	public List<lgoodstype> GetAllgt() {
		List<goodstype> l=gsmapper.ngdfind(0);
		List<lgoodstype> ddl=new ArrayList<lgoodstype>();
		for (goodstype goodstype : l) {
			List<goodstype> dl=gsmapper.ngdfind(goodstype.getId());
			lgoodstype ls=new lgoodstype();
			ls.setId(goodstype.getId());
			ls.setName(goodstype.getName());
			ls.setPinyin(goodstype.getPinyin());
			ls.setSlist(dl);
			ls.setTypeid(goodstype.getTypeid());
			ddl.add(ls);
		}
		return ddl;
	}
	@Override
	public goodstype getByid(Integer id) {
		goodstype get=gsmapper.findByid(id);
		return get;
	}

}
