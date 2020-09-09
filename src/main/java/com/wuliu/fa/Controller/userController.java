package com.wuliu.fa.Controller;


import java.text.MessageFormat;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wuliu.fa.Exception.WarnException;
import com.wuliu.fa.annonation.Log;
import com.wuliu.fa.entity.User;
import com.wuliu.fa.entity.company;
import com.wuliu.fa.service.CompanyService;
import com.wuliu.fa.service.IUserService;
import com.wuliu.fa.util.Constant;
import com.wuliu.fa.util.MD5Utils;
import com.wuliu.fa.util.ResponseResult;

@Controller
public class userController extends BaseController {
	@Autowired
	IUserService userInfoService;
	@Autowired
	IUserService userService;
	@Autowired
	private CompanyService companyservice;
	private static final Logger LOGGER = LoggerFactory.getLogger(userController.class);
	//验证用户名
	@GetMapping("/nameis")
	@ResponseBody
	public ResponseResult<Integer> nameis (String name){
		//查询手机号看有用户没
		User u=userService.findByUName(name);
		if(u==null){
			return new ResponseResult<Integer>(SUCCESS);
		}else{
			return new ResponseResult<Integer>(WARN);
		}


	}
	//前端注册接口
	@PostMapping("/useregister")
	@ResponseBody
	public ResponseResult<Integer> useregister (HttpSession session,String username,String name,String mobile,Integer xian1,String password,
			String address,String company,String city,Integer type) {
		User us=new User();
		//有公司的添加公司
		//System.err.println(company);
		if(company!=null){
			company p=new company();
			p.setCtoname(company);
			p.setHylx(0);
			p.setLianxiren(username);
			p.setLianxitel(mobile);
			p.setWx(mobile);
			p.setXian1(xian1);
			p.setXiancn(city);
			p.setXxaddress(address);
			//注册人姓名
			p.setName(name);
			p.setGslx(type);
			companyservice.saveCompany(p);
			company c=companyservice.Getbyname(name);
			us.setCompanyid(c.getId());
			us.setCompany(company);
		}
		//添加用户
		us.setName(name);
		us.setMobile(mobile);
		us.setPassword(MD5Utils.getMd5Password(password));
		us.setType(type);
		us.setAddress("");
		//出发地   id
		us.setBranchid(xian1);
		us.setDelFlag(0);
		us.setCity(city);
		//非会员
		us.setPermissionid("0");
		us.setHeadimgurl("");
		userService.addUser(us);
		session.setAttribute(Constant.USER_TOKEN, us);
		return new ResponseResult<Integer>(SUCCESS);


	}
	@Log("登录前端管理页面")
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Integer> login(HttpSession session,
			@RequestParam String username,
			@RequestParam String password) {
		User userInfo = userInfoService.findByUName(username);
		//System.err.println(userInfo);
		if (userInfo == null) {
			throw new WarnException("不存在该用户名");
		}  
		if (!userInfo.getPassword().equals(MD5Utils.getMd5Password(password))) {
			throw new WarnException("密码不正确");
		}
		session.setAttribute(Constant.USER_TOKEN, userInfo);
		userInfo.setPassword("");
		Integer type=userInfo.getType();
		return new ResponseResult<Integer>(SUCCESS,type);
	}
	//@Log("重置密码")
	@RequestMapping(value = "setpassword", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<User> setpassword(
			@RequestParam String username,
			@RequestParam String password) {
		User userInfo = userInfoService.findByUName(username);
		//System.err.println(userInfo);
		if (userInfo == null) {
			throw new WarnException("不存在该用户名");
		}  
		userInfo.setPassword(MD5Utils.getMd5Password(password));
		userInfoService.UpdateUserInfo(userInfo, userInfo.getRid());

		return new ResponseResult<User>(SUCCESS);
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		Object userId = session.getAttribute(Constant.USER_TOKEN);
		if (userId == null) {
			throw new WarnException("请先登录！");
		}
		session.removeAttribute(Constant.USER_TOKEN);
		LOGGER.info(MessageFormat.format("userId为 {0} 的用户已注销登录!", userId));
		return "login";
	}

}
