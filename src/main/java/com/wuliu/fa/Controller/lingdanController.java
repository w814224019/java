package com.wuliu.fa.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.wuliu.fa.config.RedisUtil;
import com.wuliu.fa.entity.area;
import com.wuliu.fa.entity.company;
import com.wuliu.fa.entity.goodstype;
import com.wuliu.fa.entity.xianlu;
import com.wuliu.fa.service.CompanyService;
import com.wuliu.fa.service.areaService;
import com.wuliu.fa.service.goodstypeService;
import com.wuliu.fa.util.Constant;

@Controller
public class lingdanController extends BaseController {
	@Autowired
	private CompanyService companyservice;
	@Autowired
	private areaService areservice;
	@Autowired
	private goodstypeService gsservice;
	@Autowired
	private RedisUtil redisUtil;
	//导航条零担页面
	@GetMapping("/lingdan")
	public String lingdan(Integer  xian1,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
			@RequestParam(defaultValue = "10",value = "pageSize")Integer pageSize,Model model,Integer zhengche){
		Page<company> companylist=new Page<company> ();
		if(pageNum<=0)pageNum=1;
		//System.err.println(zhengche);
		if(zhengche==null)zhengche=0;
		if(zhengche==1){
			companylist=companyservice.getBycn(xian1,1, pageSize, pageNum);
		}else if(zhengche==2){
			companylist=companyservice.getBycnz(xian1, pageSize, pageNum,1);	
		}
		//System.err.println(companylist);
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
		model.addAttribute("companylist", companylist);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("xian1", xian1);
		model.addAttribute("sta", sta);
		model.addAttribute("zhengche", zhengche);
		model.addAttribute("yuming", Constant.yuming);
		return "lingdan";
	}
	//导航条大件页面
	@GetMapping("/dajian")
	public String dajian(Integer  xian1,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
			@RequestParam(defaultValue = "10",value = "pageSize")Integer pageSize,Model model,Integer id){
		if(pageNum<=0)pageNum=1;
		Page<company> companylist=companyservice.getBycnz(xian1, pageSize, pageNum,0);	
		//System.err.println(companylist);
		area  sta=areservice.GetdByid(xian1);
		Integer shengid=sta.getShengxid();
		List<area> dijishi=new ArrayList<area>();
		if(redisUtil.hasKey("zongzhan"+shengid)){
			dijishi=(List<area>) redisUtil.get("zongzhan"+shengid);
		}else{
			dijishi=areservice.GetByshengxi(shengid, 1);
		}
		model.addAttribute("dijishi", dijishi);
		goodstype d=gsservice.getByid(id);
		List<xianlu> x=Constant.centers(xian1, sta.getXname());
		model.addAttribute("xianguan", x);
		model.addAttribute("companylist", companylist);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("xian1", xian1);
		model.addAttribute("sta", sta);
		model.addAttribute("gs", d);
		model.addAttribute("yuming", Constant.yuming);
		return "dajian";
	}
}
