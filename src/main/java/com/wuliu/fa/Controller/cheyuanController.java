package com.wuliu.fa.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.wuliu.fa.Exception.WarnException;
import com.wuliu.fa.config.RedisUtil;
import com.wuliu.fa.entity.area;
import com.wuliu.fa.entity.carUser;
import com.wuliu.fa.entity.company;
import com.wuliu.fa.entity.xianlu;
import com.wuliu.fa.service.CompanyService;
import com.wuliu.fa.service.IcarUserService;
import com.wuliu.fa.service.areaService;
import com.wuliu.fa.util.Constant;
import com.wuliu.fa.util.ResponseResult;

@Controller
public class cheyuanController extends BaseController  {
	@Autowired
	private IcarUserService caruserService;
	@Autowired
	private areaService areservice;
	@Autowired
	private CompanyService companyservice;
	@Autowired
	private RedisUtil redisUtil;
	//车源发布页
	@GetMapping("/cyfabuxinxi")
	public String cyfabuxinxi(Integer xian1,Model model){
		model.addAttribute("xian1", xian1);
		return "cyfabuxinxi";
	}
	//发布车源信息
	@PostMapping("/addcar")
	@ResponseBody
	public ResponseResult<Integer> addcar (String phone,String type,String chang,String city,String destination,
		String lianxiren,String carLicense,String remark,Integer xian1){
		carUser v=new carUser();
		v.setCarLicense(carLicense);
		v.setPhone(phone);
		v.setChang(chang);
		v.setCity(city);
		v.setDestination(destination);
		v.setPicturePath("");
		v.setRemark(remark);
		v.setUserid(6);
		v.setStatus("长期有效");
		v.setType(type);
		v.setXian1(xian1);
		v.setLianxiren(lianxiren);
		caruserService.Sadd(v);
		if(redisUtil.hasKey("cheyuan"+xian1)){
			redisUtil.del("cheyuan"+xian1);
		}
		return new ResponseResult<Integer>(SUCCESS);
		
	}
	//车源列表
	@GetMapping("/cheyuan")
	public String po (Integer  xian1,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
			@RequestParam(defaultValue = "10",value = "pageSize")Integer pageSize,Model model){
		if(pageNum<=0)pageNum=1;
		Page<carUser> carUserlist=caruserService.getcarusers(pageNum, pageSize);
		if(carUserlist.size()<8){
			carUserlist=caruserService.getcarusers(1, 10);
		}
		//System.err.println(carUserlist);
		area  sta=areservice.GetdByid(xian1);
		Integer shengid=sta.getShengxid();
		List<area> dijishi=new ArrayList<area>();
		if(redisUtil.hasKey("zongzhan"+shengid)){
			dijishi=(List<area>) redisUtil.get("zongzhan"+shengid);
		}else{
			dijishi=areservice.GetByshengxi(shengid, 1);
		}
		model.addAttribute("dijishi", dijishi);
		List<xianlu> x=Constant.centers(xian1, sta.getXname());
		model.addAttribute("xianguan", x);
		model.addAttribute("cheyuan", carUserlist);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("sta", sta);
		model.addAttribute("yuming", Constant.yuming);
		return "cheyuan";
	}
	//车源信息
	@GetMapping("/cheinfo")
	public String cheinfo (Integer  xian1,Integer id,Model model){
		carUser c=caruserService.getcarUserByi(id);
		area  sta=areservice.GetdByid(xian1);
		Integer shengid=sta.getShengxid();
		List<area> dijishi=new ArrayList<area>();
		if(redisUtil.hasKey("zongzhan"+shengid)){
			dijishi=(List<area>) redisUtil.get("zongzhan"+shengid);
		}else{
			dijishi=areservice.GetByshengxi(shengid, 1);
		}
		model.addAttribute("dijishi", dijishi);
		Page<company> comlist=companyservice.youzhicom(xian1);
		model.addAttribute("che", c);
		model.addAttribute("sta", sta);
		model.addAttribute("yzcomps", comlist);
		model.addAttribute("yuming", Constant.yuming);
		return "203/cheinfo";
	
}
}