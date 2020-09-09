package com.wuliu.fa.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wuliu.fa.entity.Texts;
import com.wuliu.fa.mapper.LogMapper;
import com.wuliu.fa.service.LogerService;

@Service
public class LoggerServiceImpl implements LogerService {
    @Autowired
    LogMapper logMapper;
    private Integer SaveLoger(Texts text){
    	return logMapper.SaveLoger(text);
    }
	@Override
	public Integer AddLoger(Texts text) {
		return SaveLoger(text);
	}
	@Override
	public Page<Texts> sfindalllogs(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		Page<Texts> s=logMapper.findalllogs();
		return s;
	}

}
