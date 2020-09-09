package com.wuliu.fa.mapper;

import com.github.pagehelper.Page;
import com.wuliu.fa.entity.Texts;

public interface LogMapper {
   /**
    * 保存记录
    */
	Integer SaveLoger(Texts text);
	/**
	 * 分页查询所有日志
	 */
	Page<Texts> findalllogs();
}
