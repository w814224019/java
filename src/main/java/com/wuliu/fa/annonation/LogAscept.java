package com.wuliu.fa.annonation;

import java.lang.reflect.Method;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.wuliu.fa.entity.Texts;
import com.wuliu.fa.entity.User;
import com.wuliu.fa.service.IUserService;
import com.wuliu.fa.service.LogerService;
import com.wuliu.fa.util.Constant;




@Aspect
@Component
public class LogAscept {
	@Autowired
	LogerService loggerService;
   @Autowired
    private IUserService userInfoService;
	private static final Logger logger = LoggerFactory.getLogger(LogAscept.class);
	@Pointcut("@annotation(com.wuliu.fa.annonation.Log)")
	public void pointcut() {
		// do nothing
	}
	
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		Object result = null;
		result = point.proceed();
		// 获取方法的关键信息，类，包
		Texts text=new Texts();
		MethodSignature signature = (MethodSignature) point.getSignature();
		Method method = signature.getMethod();
		Log sysLog = method.getAnnotation(Log.class);
		if(sysLog != null) {
			//注解上的描述
			text.setContents(sysLog.value());
		}
		//请求的 类名、方法名
		String className = point.getTarget().getClass().getName();
		String methodName = signature.getName();
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		User u = (User)session.getAttribute(Constant.USER_TOKEN);
//		 Integer rid=Integer.parseInt(String.valueOf(userId));
//		 User u=userInfoService.getById(rid);
		 System.err.println(u);
		//请求的参数，获得当前的参数，公司id，名称，其他信息
	/*	Object[] args = point.getArgs();
		List<String> list = new ArrayList<String>();
		try {
			for (Object o : args) {
				list.add(o.toString());
			}
		} catch (Exception e){
			logger.info(e.getMessage());

		}*/
		// System.err.println("方法参数："+list.get(0));
		text.setCompanyId(u.getCompanyid());
		text.setCompanyName(u.getCompany());
		text.setCreater("类名："+className);
		text.setFunctions("方法名："+methodName);
		text.setModifiedTime(new Date());
		text.setModifiedUser(u.getName());
		logger.info("存入日志");
		loggerService.AddLoger(text);
		
		return result;
	}

}
