package com.wuliu.fa.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuliu.fa.entity.User;
import com.wuliu.fa.entity.company;
import com.wuliu.fa.service.CompanyService;
import com.wuliu.fa.util.Constant;

@Controller
@RequestMapping("/vipPage")
public class vipPageController {
	@Autowired
	private CompanyService companyservice;
	//进入后台页面
	@GetMapping("")
	public String vipPage(HttpSession session,Model model){
		User u=(User) session.getAttribute(Constant.USER_TOKEN);
		Integer id=u.getCompanyid();
		company c=companyservice.getById(id);
		model.addAttribute("company", c);
		model.addAttribute("u", u);
		return "vip/vipPage";
	}
	@GetMapping("/vipdingdanPage")
	public String vipdingdanPage(HttpSession session,Model model){
		User u=(User) session.getAttribute(Constant.USER_TOKEN);
		Integer id=u.getCompanyid();
		company c=companyservice.getById(id);
		model.addAttribute("company", c);
		model.addAttribute("u", u);
		model.addAttribute("yuming", Constant.yuming);
		return "vip/vipdingdanPage";
	}
	//修改密码
	@GetMapping("/xiugaimima")
	public String xiugaimima(HttpSession session,Model model){
		User u=(User) session.getAttribute(Constant.USER_TOKEN);
		Integer id=u.getCompanyid();
		company c=companyservice.getById(id);
		model.addAttribute("company", c);
		model.addAttribute("u", u);
		model.addAttribute("yuming", Constant.yuming);
		return "vip/xiugaimima";
	}
	
}
