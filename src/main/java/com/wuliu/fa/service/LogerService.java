package com.wuliu.fa.service;


import com.github.pagehelper.Page;
import com.wuliu.fa.entity.Texts;

public interface LogerService {
	 Integer AddLoger(Texts text);
	 /**
		 * 分页查询所有日志
		 */
		Page<Texts> sfindalllogs(Integer pageNum,Integer pageSize);
}
