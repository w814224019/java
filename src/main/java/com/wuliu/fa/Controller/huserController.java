package com.wuliu.fa.Controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.wuliu.fa.entity.User;
import com.wuliu.fa.entity.fahRecoreder;
import com.wuliu.fa.service.IfahRecorederService;
import com.wuliu.fa.util.Constant;
@Controller
@RequestMapping("/huser")
public class huserController extends BaseController {

	//货主后台
	@GetMapping("")
	public String huser(HttpSession session,Model model){
		User u=(User) session.getAttribute(Constant.USER_TOKEN);
		model.addAttribute("u", u);
		model.addAttribute("yuming", Constant.yuming);
		return "huozhu/huser";
	}

	//货主后台
	@GetMapping("wodedingdan")
	public String wodedingdan(HttpSession session,Model model){
		User u=(User) session.getAttribute(Constant.USER_TOKEN);
		model.addAttribute("u", u);
		model.addAttribute("yuming", Constant.yuming);
		return "huozhu/wodedingdan";
	}
   

}
