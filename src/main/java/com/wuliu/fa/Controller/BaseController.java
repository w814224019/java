package com.wuliu.fa.Controller;


import javax.security.auth.login.AccountException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuliu.fa.Exception.RequestException;
import com.wuliu.fa.Exception.ServiceException;
import com.wuliu.fa.Exception.WarnException;
import com.wuliu.fa.util.ResponseResult;






/**
 * 当前项目中所有控制器类的基类
 * 跳到网点代号202，管理员代号201，普通用户代号203
 */
public class BaseController {
	/**
	 * 正确响应时的代号
	 */
	public static final Integer SUCCESS = 200;
	//跳到网点
	public static final Integer SUCCESS1 = 202;
	//管理员
	public static final Integer ADMIN = 201;
	//普通用户
	public static final Integer PUBLIC = 203;
	public static final Integer SHIRO = 401;
	public static final Integer WARN = 402;
	
	
	@ExceptionHandler({RequestException.class,ServiceException.class})
	@ResponseBody
	public ResponseResult<Void> handleException(
			Exception e) {
		Integer state = null;
		
		if (e instanceof AccountException) {
			// 401-违反了shiro验证的异常
			state = 401;
			
		}else if (e instanceof WarnException) {
			// 402-前端警告异常
			state = 402;
		} 
		
		return new ResponseResult<>(state, e.getMessage());
	
}
	
	
	
	
}