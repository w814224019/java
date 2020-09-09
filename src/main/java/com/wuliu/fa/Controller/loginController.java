package com.wuliu.fa.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wuliu.fa.util.Constant;

@Controller
public class loginController extends BaseController{
	//登录页
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	//注册页
	@GetMapping("/register")
	public String register(){
		return "register";
	}
	//注册页
	@GetMapping("/zhuce")
	public String zhuce(Model model){
		model.addAttribute("yuming", Constant.yuming);
		return "register/zhuce";
	}
	//注册页
	@GetMapping("/zhucet")
	public String zhucet(Model model,Integer type){
		model.addAttribute("yuming", Constant.yuming);
		model.addAttribute("type", type);
		return "register/zhucet";
	}


}
